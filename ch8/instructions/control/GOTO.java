package ch8.instructions.control;

import ch8.instructions.base.BranchInstruction;
import ch8.instructions.base.BranchLogic;
import ch8.rtda.Fram;

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
