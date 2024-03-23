package ch7.instructions.conversions.l2x;

import ch7.instructions.base.NoOperandsInstruction;
import ch7.rtda.Fram;
import ch7.rtda.OperandStack;

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
