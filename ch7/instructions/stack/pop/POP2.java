package ch7.instructions.stack.pop;

import ch7.instructions.base.NoOperandsInstruction;
import ch7.rtda.Fram;
import ch7.rtda.OperandStack;

public class POP2 extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        stack.popSlot();
        stack.popSlot();
    }
}
