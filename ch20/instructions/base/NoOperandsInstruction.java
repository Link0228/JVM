package ch20.instructions.base;

public abstract class NoOperandsInstruction extends Instruction{
    /**
     * @param reader
     */
    @Override
    public void fetchOperands(BytecodeReader reader) {
            // nothing to do
    }
}
