package ch8.instructions.math.sh;

import ch8.instructions.base.NoOperandsInstruction;
import ch8.rtda.Fram;
import ch8.rtda.OperandStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/14:59
 * @Description:
 */
public class LSHL extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        int v2=stack.popInt();
        long v1=stack.popLong();
        long s=Integer.toUnsignedLong(v2)&0x3f;
        long result=v1<<s;
        stack.pushLong(result);
    }
}