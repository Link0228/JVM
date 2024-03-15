package ch5.instructions.base;

public abstract class BranchInstruction implements Instruction{
    public int offset;


    /**
     * @param reader
     */
    @Override
    public void fetchOperands(BytecodeReader reader) {
        offset=(int)reader.readInt16();
    }
}
