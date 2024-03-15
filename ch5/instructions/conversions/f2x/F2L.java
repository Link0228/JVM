package ch5.instructions.conversions.f2x;

import ch5.instructions.base.NoOperandsInstruction;
import ch5.rtda.Fram;
import ch5.rtda.OperandStack;

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
