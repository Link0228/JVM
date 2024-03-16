package ch6.instructions.constants;

import ch6.rtda.Fram;
import ch6.instructions.base.BytecodeReader;
import ch6.instructions.base.Instruction;

public class SIPUSH extends Instruction {
    private short val;
    /**
     * @param reader
     */
    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.val=reader.readInt16();
    }

    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        int i=(int)val;
        fram.getOperandStack().pushInt(i);
    }
}
