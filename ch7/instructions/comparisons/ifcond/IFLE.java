package ch7.instructions.comparisons.ifcond;

import ch7.instructions.base.BranchInstruction;
import ch7.instructions.base.BranchLogic;
import ch7.rtda.Fram;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/15/10:26
 * @Description:
 */
public class IFLE extends BranchInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        int val=fram.getOperandStack().popInt();
        if(val<=0){
            BranchLogic.branch(fram,this.offset);
        }
    }
}
