package ch5.instructions.constants;

import ch5.rtda.Fram;
import ch5.instructions.base.BytecodeReader;
import ch5.instructions.base.Instruction;

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
