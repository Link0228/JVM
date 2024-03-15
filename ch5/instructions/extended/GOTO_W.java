package ch5.instructions.extended;

import ch5.instructions.base.BranchLogic;
import ch5.instructions.base.BytecodeReader;
import ch5.instructions.base.Instruction;
import ch5.rtda.Fram;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/15/16:53
 * @Description:
 */
public class GOTO_W implements Instruction {

    private int offset;
    /**
     * @param reader
     */
    @Override
    public void fetchOperands(BytecodeReader reader) {
        offset= reader.readInt32();
    }

    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        BranchLogic.branch(fram,offset);
    }
}
