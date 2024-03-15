package ch5.instructions.stack.swap;

import ch5.instructions.base.NoOperandsInstruction;
import ch5.rtda.Fram;
import ch5.rtda.OperandStack;
import ch5.rtda.Slote;

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
