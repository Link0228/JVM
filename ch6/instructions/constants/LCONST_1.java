package ch6.instructions.constants;

import ch6.rtda.Fram;
import ch6.instructions.base.NoOperandsInstruction;

public class LCONST_1 extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        fram.getOperandStack().pushLong(1L);
    }
}
