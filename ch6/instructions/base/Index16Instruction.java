package ch6.instructions.base;

public abstract class Index16Instruction extends Instruction{
    public int index;

    /**
     * @param reader
     */
    @Override
    public void fetchOperands(BytecodeReader reader) {
        index=reader.readUint16();
    }
}
