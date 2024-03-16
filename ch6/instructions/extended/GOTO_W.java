package ch6.instructions.extended;

import ch6.instructions.base.BranchLogic;
import ch6.instructions.base.BytecodeReader;
import ch6.instructions.base.Instruction;
import ch6.rtda.Fram;

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
