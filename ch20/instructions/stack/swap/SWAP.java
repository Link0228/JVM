package ch20.instructions.stack.swap;

import ch20.instructions.base.NoOperandsInstruction;
import ch20.rtda.Fram;
import ch20.rtda.OperandStack;
import ch20.rtda.Slote;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/13/21:49
 * @Description:
 */
public class SWAP extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        Slote slot1=stack.popSlot();
        Slote slot2=stack.popSlot();
        stack.pushSlot(slot1);
        stack.pushSlot(slot2);
    }
}
