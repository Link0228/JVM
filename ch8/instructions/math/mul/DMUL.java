package ch8.instructions.math.mul;

import ch8.instructions.base.NoOperandsInstruction;
import ch8.rtda.Fram;
import ch8.rtda.OperandStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/14:36
 * @Description:
 */
public class DMUL extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        double v2=stack.popDouble();
        double v1=stack.popDouble();
        double result=v1*v2;
        stack.pushDouble(result);
    }
}
