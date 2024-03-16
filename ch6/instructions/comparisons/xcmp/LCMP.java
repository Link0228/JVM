package ch6.instructions.comparisons.xcmp;

import ch6.instructions.base.NoOperandsInstruction;
import ch6.rtda.Fram;
import ch6.rtda.OperandStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/15/10:07
 * @Description:
 */
public class LCMP extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        long v2=stack.popLong();
        long v1=stack.popLong();
        if(v1>v2){
            stack.pushInt(1);
        }else if(v1==v2){
            stack.pushInt(0);
        }else{
            stack.pushInt(-1);
        }
    }
}
