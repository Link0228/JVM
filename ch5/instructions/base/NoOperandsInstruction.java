package ch5.instructions.base;

public abstract class NoOperandsInstruction implements Instruction{
    /**
     * @param reader
     */
    @Override
    public void fetchOperands(BytecodeReader reader) {
            // nothing to do
    }
}
