package ch20.instructions.constants;

import ch20.rtda.Fram;
import ch20.instructions.base.NoOperandsInstruction;

public class ACONST_NULL extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        fram.getOperandStack().pushRef(null);
    }
}
