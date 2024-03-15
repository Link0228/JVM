package ch20.instructions.constants;

import ch20.rtda.Fram;
import ch20.instructions.base.NoOperandsInstruction;

public class FCONST_2 extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        fram.getOperandStack().pushFloat(2.0f);
    }
}
