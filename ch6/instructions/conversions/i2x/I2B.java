package ch6.instructions.conversions.i2x;

import ch6.instructions.base.NoOperandsInstruction;
import ch6.rtda.Fram;
import ch6.rtda.OperandStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/15/9:49
 * @Description:
 */
public class I2B extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        int i= stack.popInt();
        byte b=(byte)i;
        stack.pushInt(b);
    }
}
