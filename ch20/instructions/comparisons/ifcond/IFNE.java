package ch20.instructions.comparisons.ifcond;

import ch20.instructions.base.BranchInstruction;
import ch20.instructions.base.BranchLogic;
import ch20.rtda.Fram;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/15/10:25
 * @Description:
 */
public class IFNE extends BranchInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        int val=fram.getOperandStack().popInt();
        if(val!=0){
            BranchLogic.branch(fram,this.offset);
        }
    }
}
