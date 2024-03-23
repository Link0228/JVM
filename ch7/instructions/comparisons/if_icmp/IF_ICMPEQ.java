package ch7.instructions.comparisons.if_icmp;

import ch7.instructions.base.BranchInstruction;
import ch7.instructions.base.BranchLogic;
import ch7.rtda.Fram;
import ch7.rtda.OperandStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/15/10:33
 * @Description:
 */
public class IF_ICMPEQ extends BranchInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        int val2=stack.popInt();
        int val1=stack.popInt();
        if(val1==val2){
            BranchLogic.branch(fram,this.offset);
        }
    }
}
