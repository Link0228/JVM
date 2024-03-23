package ch7.instructions.stack.dup;

import ch7.instructions.base.NoOperandsInstruction;
import ch7.rtda.Fram;
import ch7.rtda.OperandStack;
import ch7.rtda.Slote;

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
