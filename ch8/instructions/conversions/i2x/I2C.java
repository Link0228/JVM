package ch8.instructions.conversions.i2x;

import ch8.instructions.base.NoOperandsInstruction;
import ch8.rtda.Fram;
import ch8.rtda.OperandStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/15/9:58
 * @Description:
 */
public class I2C extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        int i= stack.popInt();
        char c=(char)i;
        stack.pushInt(c);
    }
}
