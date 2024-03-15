package ch20.instructions.math.sh;

import ch20.instructions.base.NoOperandsInstruction;
import ch20.rtda.Fram;
import ch20.rtda.OperandStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/13/22:12
 * @Description:
 */
public class LSHR extends NoOperandsInstruction {
    /**
     *
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        int v2=stack.popInt();
        long v1=stack.popLong();
        long s=Integer.toUnsignedLong(v2)&0x3f;
        long result=v1>>s;
        stack.pushLong(result);
    }
}
