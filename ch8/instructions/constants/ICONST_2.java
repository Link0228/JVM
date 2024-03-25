package ch8.instructions.constants;

import ch8.rtda.Fram;
import ch8.instructions.base.NoOperandsInstruction;

public class ICONST_2 extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        fram.getOperandStack().pushInt(2);
    }
}
