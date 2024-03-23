package ch7.instructions.comparisons.if_acmp;

import ch7.instructions.base.BranchInstruction;
import ch7.instructions.base.BranchLogic;
import ch7.rtda.Fram;
import ch7.rtda.heap.Objext;
import ch7.rtda.OperandStack;

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
