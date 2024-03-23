package ch7.instructions.stack.dup;

import ch7.instructions.base.NoOperandsInstruction;
import ch7.rtda.Fram;
import ch7.rtda.OperandStack;
import ch7.rtda.Slote;

public class DUP_X1 extends NoOperandsInstruction {
    /**
     * 前：......,word2,word1
     * 后：......,word1,word2,word1
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        Slote slot1=stack.popSlot();
        Slote slot2=stack.popSlot();
        stack.pushSlot(slot1);
        stack.pushSlot(slot2);
        stack.pushSlot(slot1);
    }
}
