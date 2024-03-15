package ch5.instructions.stack.pop;

import ch5.instructions.base.NoOperandsInstruction;
import ch5.rtda.Fram;
import ch5.rtda.OperandStack;

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
