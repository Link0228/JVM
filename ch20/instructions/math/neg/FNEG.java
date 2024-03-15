package ch20.instructions.math.neg;

import ch20.instructions.base.NoOperandsInstruction;
import ch20.rtda.Fram;
import ch20.rtda.OperandStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/14:43
 * @Description:
 */
public class FNEG extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        float v=stack.popFloat();
        float result=-v;
        stack.pushFloat(result);
    }
}
