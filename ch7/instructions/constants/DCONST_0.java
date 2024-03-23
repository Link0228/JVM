package ch7.instructions.constants;

import ch7.rtda.Fram;
import ch7.instructions.base.NoOperandsInstruction;

public class DCONST_0 extends NoOperandsInstruction {
    /**
     * 把double型0推入操作数栈顶
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        fram.getOperandStack().pushDouble(0.0);
    }
}
