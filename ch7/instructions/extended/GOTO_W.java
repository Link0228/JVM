package ch7.instructions.extended;

import ch7.instructions.base.BranchLogic;
import ch7.instructions.base.BytecodeReader;
import ch7.instructions.base.Instruction;
import ch7.rtda.Fram;

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
