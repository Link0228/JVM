package ch20.instructions.math.div;

import ch20.instructions.base.NoOperandsInstruction;
import ch20.rtda.Fram;
import ch20.rtda.OperandStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/14:39
 * @Description:
 */
public class LDIV extends NoOperandsInstruction {
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
        long result=v1/v2;
        stack.pushLong(result);
    }
}
