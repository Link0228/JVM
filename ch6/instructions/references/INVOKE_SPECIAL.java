package ch6.instructions.references;

import ch6.instructions.base.Index16Instruction;
import ch6.rtda.Fram;

public class INVOKE_SPECIAL extends Index16Instruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        //todo
        fram.getOperandStack().popRef();
    }
}
