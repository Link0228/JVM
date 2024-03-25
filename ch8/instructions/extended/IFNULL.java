package ch8.instructions.extended;

import ch8.instructions.base.BranchInstruction;
import ch8.instructions.base.BranchLogic;
import ch8.rtda.Fram;
import ch8.rtda.heap.Objext;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/15/16:51
 * @Description:
 */
public class IFNULL extends BranchInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        Objext ref=fram.getOperandStack().popRef();
        if(ref==null){
            BranchLogic.branch(fram,this.offset);
        }
    }
}
