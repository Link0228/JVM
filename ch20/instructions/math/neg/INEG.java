package ch20.instructions.math.neg;

import ch20.instructions.base.NoOperandsInstruction;
import ch20.rtda.Fram;
import ch20.rtda.OperandStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/14:42
 * @Description:
 */
public class INEG extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        int v=stack.popInt();
        int result=-v;
        stack.pushInt(result);
    }
}
