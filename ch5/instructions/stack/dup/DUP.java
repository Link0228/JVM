package ch5.instructions.stack.dup;

import ch5.instructions.base.NoOperandsInstruction;
import ch5.rtda.Fram;
import ch5.rtda.OperandStack;
import ch5.rtda.Slote;

public class DUP extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        Slote slot=stack.popSlot();
        stack.pushSlot(slot);
        stack.pushSlot(slot);
    }
}
