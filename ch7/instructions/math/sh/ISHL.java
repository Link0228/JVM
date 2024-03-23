package ch7.instructions.math.sh;

import ch7.instructions.base.NoOperandsInstruction;
import ch7.rtda.Fram;
import ch7.rtda.OperandStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/13/22:08
 * @Description:
 */
public class ISHL extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        int v2=stack.popInt();
        int v1=stack.popInt();
        long s=Integer.toUnsignedLong(v2)&0x1f;
        int result=v1<<s;
        stack.pushInt(result);
    }
}
