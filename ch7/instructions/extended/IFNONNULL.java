package ch7.instructions.extended;

import ch7.instructions.base.BranchInstruction;
import ch7.instructions.base.BranchLogic;
import ch7.rtda.Fram;
import ch7.rtda.heap.Objext;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/15/16:53
 * @Description:
 */
public class IFNONNULL extends BranchInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        Objext ref=fram.getOperandStack().popRef();
        if(ref!=null){
            BranchLogic.branch(fram,this.offset);
        }
    }
}
