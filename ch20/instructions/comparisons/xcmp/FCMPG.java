package ch20.instructions.comparisons.xcmp;

import ch20.instructions.base.NoOperandsInstruction;
import ch20.rtda.Fram;
import ch20.rtda.OperandStack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/15/10:20
 * @Description:
 */
public class FCMPG extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        float v2=stack.popFloat();
        float v1=stack.popFloat();
        if(Float.isNaN(v1)||Float.isNaN(v2)){
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
