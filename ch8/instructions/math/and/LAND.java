package ch8.instructions.math.and;

import ch8.instructions.base.NoOperandsInstruction;
import ch8.rtda.Fram;
import ch8.rtda.OperandStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/9:49
 * @Description:
 */
public class LAND extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        long v2=stack.popLong();
        long v1=stack.popLong();
        long result=v1&v2;
        stack.pushLong(result);
    }
}
