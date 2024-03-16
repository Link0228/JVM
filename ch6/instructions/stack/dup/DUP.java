package ch6.instructions.stack.dup;

import ch6.instructions.base.NoOperandsInstruction;
import ch6.rtda.Fram;
import ch6.rtda.OperandStack;
import ch6.rtda.Slote;

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
