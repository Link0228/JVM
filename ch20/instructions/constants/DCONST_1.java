package ch20.instructions.constants;

import ch20.rtda.Fram;
import ch20.instructions.base.NoOperandsInstruction;

public class DCONST_1 extends NoOperandsInstruction {
    /**
     * 把double型1推入操作数栈顶
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        fram.getOperandStack().pushDouble(1.0);
    }
}
