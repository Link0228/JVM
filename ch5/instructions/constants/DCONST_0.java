package ch5.instructions.constants;

import ch5.rtda.Fram;
import ch5.instructions.base.NoOperandsInstruction;

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
