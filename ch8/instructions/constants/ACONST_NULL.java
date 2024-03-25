package ch8.instructions.constants;

import ch8.rtda.Fram;
import ch8.instructions.base.NoOperandsInstruction;

public class ACONST_NULL extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        fram.getOperandStack().pushRef(null);
    }
}
