package ch7.instructions.math.div;

import ch7.instructions.base.NoOperandsInstruction;
import ch7.rtda.Fram;
import ch7.rtda.OperandStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/14:37
 * @Description:
 */
public class IDIV extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        int v2=stack.popInt();
        int v1=stack.popInt();
        if(v2==0){
            throw new ArithmeticException("/ by zero");
        }
        int result=v1/v2;
        stack.pushInt(result);
    }
}
