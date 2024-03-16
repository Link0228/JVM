package ch6.instructions.control;

import ch6.instructions.base.BranchInstruction;
import ch6.instructions.base.BranchLogic;
import ch6.rtda.Fram;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/15/10:44
 * @Description:
 */
public class GOTO extends BranchInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        BranchLogic.branch(fram,this.offset);
    }
}
