package ch20.instructions.comparisons.if_icmp;

import ch20.instructions.base.BranchInstruction;
import ch20.instructions.base.BranchLogic;
import ch20.rtda.Fram;
import ch20.rtda.OperandStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/15/10:34
 * @Description:
 */
public class IF_ICMPGT extends BranchInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        int val2=stack.popInt();
        int val1=stack.popInt();
        if(val1>val2){
            BranchLogic.branch(fram,this.offset);
        }
    }
}
