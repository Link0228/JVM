package ch20.instructions.comparisons.if_acmp;

import ch20.instructions.base.BranchInstruction;
import ch20.instructions.base.BranchLogic;
import ch20.rtda.Fram;
import ch20.rtda.Objext;
import ch20.rtda.OperandStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/15/10:39
 * @Description:
 */
public class IF_ACMPEQ extends BranchInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        Objext ref2=stack.popRef();
        Objext ref1=stack.popRef();
        if(ref1==ref2){
            BranchLogic.branch(fram,offset);
        }
    }
}
