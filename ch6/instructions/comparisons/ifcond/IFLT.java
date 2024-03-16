package ch6.instructions.comparisons.ifcond;

import ch6.instructions.base.BranchInstruction;
import ch6.instructions.base.BranchLogic;
import ch6.rtda.Fram;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/15/10:26
 * @Description:
 */
public class IFLT extends BranchInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        int val=fram.getOperandStack().popInt();
        if(val<0){
            BranchLogic.branch(fram,this.offset);
        }
    }
}
