package ch8.instructions.conversions.d2x;

import ch8.instructions.base.NoOperandsInstruction;
import ch8.rtda.Fram;
import ch8.rtda.OperandStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/9:59
 * @Description:
 */
public class D2F extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        double d= stack.popDouble();
        float f=(float) d;
        stack.pushFloat(f);
    }
}
