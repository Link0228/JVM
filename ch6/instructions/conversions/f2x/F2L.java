package ch6.instructions.conversions.f2x;

import ch6.instructions.base.NoOperandsInstruction;
import ch6.rtda.Fram;
import ch6.rtda.OperandStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/15/10:04
 * @Description:
 */
public class F2L extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        float f=stack.popFloat();
        long l=(long) f;
        stack.pushLong(l);
    }
}
