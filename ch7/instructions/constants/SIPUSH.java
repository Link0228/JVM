package ch7.instructions.constants;

import ch7.rtda.Fram;
import ch7.instructions.base.BytecodeReader;
import ch7.instructions.base.Instruction;

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
