package ch8.instructions.math.rem;

import ch8.instructions.base.NoOperandsInstruction;
import ch8.rtda.Fram;
import ch8.rtda.OperandStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/13/22:03
 * @Description:
 */
public class LREM extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        long v2=stack.popLong();
        long v1=stack.popLong();
        if(v2==0){
            throw new ArithmeticException("/ by zero");
        }
        long result=v1%v2;
        stack.pushLong(result);
    }
}
