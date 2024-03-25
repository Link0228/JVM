package ch8.instructions.math.rem;

import ch8.instructions.base.NoOperandsInstruction;
import ch8.rtda.Fram;
import ch8.rtda.OperandStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/13/21:52
 * @Description:
 */
public class IREM extends NoOperandsInstruction {
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
        int result=v1%v2;
        stack.pushInt(result);
    }
}
