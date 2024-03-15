package ch20.instructions.stack.dup;

import ch20.instructions.base.NoOperandsInstruction;
import ch20.rtda.Fram;
import ch20.rtda.OperandStack;
import ch20.rtda.Slote;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/13/21:47
 * @Description:
 */
public class DUP2_X2 extends NoOperandsInstruction {
    /**
     * 前：......,word4,word3,word2,word1
     * 后：.......,word2,word1,word4,word3,word2,word1
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        Slote slot1=stack.popSlot();
        Slote slot2=stack.popSlot();
        Slote slot3=stack.popSlot();
        Slote slot4=stack.popSlot();
        stack.pushSlot(slot2);
        stack.pushSlot(slot1);
        stack.pushSlot(slot4);
        stack.pushSlot(slot3);
        stack.pushSlot(slot2);
        stack.pushSlot(slot1);
    }
}
