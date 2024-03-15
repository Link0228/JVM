package ch5.instructions.control;

import ch5.instructions.base.BranchInstruction;
import ch5.instructions.base.BranchLogic;
import ch5.rtda.Fram;

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
