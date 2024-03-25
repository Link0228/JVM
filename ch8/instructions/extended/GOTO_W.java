package ch8.instructions.extended;

import ch8.instructions.base.BranchLogic;
import ch8.instructions.base.BytecodeReader;
import ch8.instructions.base.Instruction;
import ch8.rtda.Fram;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/15/16:53
 * @Description:
 */
public class GOTO_W extends Instruction {

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
