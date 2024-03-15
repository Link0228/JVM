package ch5.instructions.math.neg;

import ch5.instructions.base.NoOperandsInstruction;
import ch5.rtda.Fram;
import ch5.rtda.OperandStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/14:44
 * @Description:
 */
public class DNEG extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        double v=stack.popDouble();
        double result=-v;
        stack.pushDouble(result);
    }
}
