package ch7.instructions.math.div;

import ch7.instructions.base.NoOperandsInstruction;
import ch7.rtda.Fram;
import ch7.rtda.OperandStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/14:40
 * @Description:
 */
public class DDIV extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        double v2=stack.popDouble();
        double v1=stack.popDouble();
        double result=v1/v2;
        stack.pushDouble(result);
    }
}
