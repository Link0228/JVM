package ch20.instructions.base;

import ch20.rtda.Fram;

public abstract class Instruction {

    /**
     * 获取操作数
     * @param reader
     */
    public abstract void fetchOperands(BytecodeReader reader);

    /**
     * 指令执行
     * @param fram
     */
    public abstract void execute(Fram fram);


    public Instruction newInstruction(byte opcode){
        return null;
    }
}
