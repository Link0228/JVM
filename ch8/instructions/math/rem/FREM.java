package ch8.instructions.math.rem;

import ch8.instructions.base.NoOperandsInstruction;
import ch8.rtda.Fram;
import ch8.rtda.OperandStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/13/22:02
 * @Description:
 */
public class FREM extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        float v2=stack.popFloat();
        float v1=stack.popFloat();
        float result=v1%v2;
        stack.pushFloat(result);
    }
}
