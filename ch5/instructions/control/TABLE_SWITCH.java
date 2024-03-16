package ch5.instructions.control;

import ch5.instructions.base.BranchLogic;
import ch5.instructions.base.BytecodeReader;
import ch5.instructions.base.Instruction;
import ch5.rtda.Fram;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/15/10:48
 * @Description:
 */
public class TABLE_SWITCH extends Instruction {
    private int defaultOffset;
    private int low;
    private int high;
    private int[] jumpOffsets;

    /**
     * @param reader
     */
    @Override
    public void fetchOperands(BytecodeReader reader) {
        reader.skipPadding();
        defaultOffset=reader.readInt32();
        low= reader.readInt32();
        high=reader.readInt32();
        int jumpOffsetsCount=high-low+1;
        jumpOffsets= reader.readInt32s(jumpOffsetsCount);
    }

    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        int index=fram.getOperandStack().popInt();
        int offset;
        if(index>=low&&index<=high){
            offset=(int)jumpOffsets[index-low];
        }else{
            offset=(int)(defaultOffset);
        }
        BranchLogic.branch(fram,offset);
    }
}
