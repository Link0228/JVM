package ch8.instructions.conversions.i2x;

import ch8.instructions.base.NoOperandsInstruction;
import ch8.rtda.Fram;
import ch8.rtda.OperandStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/15/9:46
 * @Description:
 */
public class I2D extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        int i= stack.popInt();
        double d=(double) i;
        stack.pushDouble(d);
    }
}
