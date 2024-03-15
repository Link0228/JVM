package ch5.instructions.constants;

import ch5.rtda.Fram;
import ch5.instructions.base.NoOperandsInstruction;

public class LCONST_1 extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        fram.getOperandStack().pushLong(1L);
    }
}
