package ch6.instructions.comparisons.xcmp;

import ch6.instructions.base.NoOperandsInstruction;
import ch6.rtda.Fram;
import ch6.rtda.OperandStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/15/10:21
 * @Description:
 */
public class DCMPG extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        double v2=stack.popDouble();
        double v1=stack.popDouble();
        if(Double.isNaN(v1)||Double.isNaN(v2)){
            stack.pushInt(1);
        }
        else if(v1>v2){
            stack.pushInt(1);
        }else if(v1==v2){
            stack.pushInt(0);
        }else{
            stack.pushInt(-1);
        }
    }
}
