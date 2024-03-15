package ch20.instructions.stack.dup;

import ch20.instructions.base.NoOperandsInstruction;
import ch20.rtda.Fram;
import ch20.rtda.OperandStack;
import ch20.rtda.Slote;

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
