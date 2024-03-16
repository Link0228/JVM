package ch6.instructions.conversions.l2x;

import ch6.instructions.base.NoOperandsInstruction;
import ch6.rtda.Fram;
import ch6.rtda.OperandStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/15/10:01
 * @Description:
 */
public class L2I extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        long l= stack.popLong();
        int i=(int)l;
        stack.pushInt(i);
    }
}
