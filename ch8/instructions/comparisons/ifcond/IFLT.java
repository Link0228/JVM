package ch8.instructions.comparisons.ifcond;

import ch8.instructions.base.BranchInstruction;
import ch8.instructions.base.BranchLogic;
import ch8.rtda.Fram;

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
