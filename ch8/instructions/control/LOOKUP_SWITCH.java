package ch8.instructions.control;

import ch8.instructions.base.BranchLogic;
import ch8.instructions.base.BytecodeReader;
import ch8.instructions.base.Instruction;
import ch8.rtda.Fram;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/15/11:06
 * @Description:
 */
public class LOOKUP_SWITCH extends Instruction {
    private int defaultOffset;
    private int npairs;
    private int[] matchOffsets;

    /**
     * @param reader
     */
    @Override
    public void fetchOperands(BytecodeReader reader) {
        reader.skipPadding();
        defaultOffset=reader.readInt32();
        npairs=reader.readInt32();
        matchOffsets=reader.readInt32s(npairs*2);
    }

    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        int key=fram.getOperandStack().popInt();
        for(int i=0;i<npairs*2;i+=2){
            if(matchOffsets[i]==key){
                int offset=(int)matchOffsets[i+1];
                BranchLogic.branch(fram,offset);
                return;
            }
        }
        BranchLogic.branch(fram,defaultOffset);
    }
}
