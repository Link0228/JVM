package ch6.instructions.math.sh;

import ch6.instructions.base.NoOperandsInstruction;
import ch6.rtda.Fram;
import ch6.rtda.OperandStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/9:00
 * @Description:
 */
public class IUSHR extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        int v2=stack.popInt();
        int v1=stack.popInt();
        long s=Integer.toUnsignedLong(v2)&0x1f;
        int result=v1>>>s;
        stack.pushInt(result);
    }
}
