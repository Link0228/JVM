package ch6.instructions.constants;

import ch6.rtda.Fram;
import ch6.instructions.base.NoOperandsInstruction;

public class FCONST_1 extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        fram.getOperandStack().pushFloat(1.0f);
    }
}
