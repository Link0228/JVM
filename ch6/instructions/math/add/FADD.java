package ch6.instructions.math.add;

import ch6.instructions.base.NoOperandsInstruction;
import ch6.rtda.Fram;
import ch6.rtda.OperandStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/14:25
 * @Description:
 */
public class FADD extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        float v2=stack.popFloat();
        float v1=stack.popFloat();
        float result=v1+v2;
        stack.pushFloat(result);
    }
}
