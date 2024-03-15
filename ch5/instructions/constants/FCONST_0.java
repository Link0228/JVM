package ch5.instructions.constants;

import ch5.rtda.Fram;
import ch5.instructions.base.NoOperandsInstruction;

public class FCONST_0 extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        fram.getOperandStack().pushFloat(0.0f);
    }
}
