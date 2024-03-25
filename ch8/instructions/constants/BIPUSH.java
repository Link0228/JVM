package ch8.instructions.constants;

import ch8.rtda.Fram;
import ch8.instructions.base.BytecodeReader;
import ch8.instructions.base.Instruction;

public class BIPUSH extends Instruction {
    private byte val;

    /**
     * @param reader
     */
    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.val=reader.readInt8();
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
