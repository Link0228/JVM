package ch7.instructions.base;

public abstract class Index8Instruction extends Instruction{
    public int index;

    /**
     * @param reader
     */
    @Override
    public void fetchOperands(BytecodeReader reader) {
        index=reader.readUint8();
    }
}
