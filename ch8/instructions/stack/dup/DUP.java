package ch8.instructions.stack.dup;

import ch8.instructions.base.NoOperandsInstruction;
import ch8.rtda.Fram;
import ch8.rtda.OperandStack;
import ch8.rtda.Slote;

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
