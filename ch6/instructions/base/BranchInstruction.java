package ch6.instructions.base;

public abstract class BranchInstruction extends Instruction{
    public int offset;


    /**
     * @param reader
     */
    @Override
    public void fetchOperands(BytecodeReader reader) {
        offset=(int)reader.readInt16();
    }
}
