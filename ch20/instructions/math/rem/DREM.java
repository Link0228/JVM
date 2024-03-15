package ch20.instructions.math.rem;

import ch20.instructions.base.NoOperandsInstruction;
import ch20.rtda.Fram;
import ch20.rtda.OperandStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/13/21:51
 * @Description:
 */
public class DREM extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        double v2=stack.popDouble();
        double v1=stack.popDouble();
        double result=v1%v2;
        stack.pushDouble(result);
    }
}
