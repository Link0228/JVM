package ch20.instructions.constants;

import ch20.rtda.Fram;
import ch20.instructions.base.NoOperandsInstruction;

public class NOP extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        // nothing to do
    }
}
