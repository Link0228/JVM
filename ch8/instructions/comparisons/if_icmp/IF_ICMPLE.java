package ch8.instructions.comparisons.if_icmp;

import ch8.instructions.base.BranchInstruction;
import ch8.instructions.base.BranchLogic;
import ch8.rtda.Fram;
import ch8.rtda.OperandStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/15/10:34
 * @Description:
 */
public class IF_ICMPLE extends BranchInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        int val2=stack.popInt();
        int val1=stack.popInt();
        if(val1<=val2){
            BranchLogic.branch(fram,this.offset);
        }
    }
}
