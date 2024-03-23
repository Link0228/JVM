package ch7.instructions.constants;

import ch7.rtda.Fram;
import ch7.instructions.base.NoOperandsInstruction;

public class ICONST_1 extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        fram.getOperandStack().pushInt(1);
    }
}
