package ch20.instructions.conversions.i2x;

import ch20.instructions.base.NoOperandsInstruction;
import ch20.rtda.Fram;
import ch20.rtda.OperandStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/15/9:31
 * @Description:
 */
public class I2L extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        int i= stack.popInt();
        long l=(int) i;
        stack.pushLong(l);
    }
}
