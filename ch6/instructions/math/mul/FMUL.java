package ch6.instructions.math.mul;

import ch6.instructions.base.NoOperandsInstruction;
import ch6.rtda.Fram;
import ch6.rtda.OperandStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/14:34
 * @Description:
 */
public class FMUL extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        float v2=stack.popFloat();
        float v1=stack.popFloat();
        float result=v1*v2;
        stack.pushFloat(result);
    }
}
