package ch5.instructions.extended;

import ch5.instructions.base.BranchInstruction;
import ch5.instructions.base.BranchLogic;
import ch5.rtda.Fram;
import ch5.rtda.Objext;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/15/16:51
 * @Description:
 */
public class IFNULL extends BranchInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        Objext ref=fram.getOperandStack().popRef();
        if(ref==null){
            BranchLogic.branch(fram,this.offset);
        }
    }
}
