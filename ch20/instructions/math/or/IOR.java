package ch20.instructions.math.or;

import ch20.instructions.base.NoOperandsInstruction;
import ch20.rtda.Fram;
import ch20.rtda.OperandStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/14:52
 * @Description:
 */
public class IOR extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        int v2=stack.popInt();
        int v1=stack.popInt();
        int result=v1|v2;
        stack.pushInt(result);
    }
}
