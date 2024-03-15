package ch5.instructions.base;

import ch5.rtda.Fram;

public interface Instruction {

    /**
     * 获取操作数
     * @param reader
     */
    void fetchOperands(BytecodeReader reader);

    /**
     * 指令执行
     * @param fram
     */
    void execute(Fram fram);
}
