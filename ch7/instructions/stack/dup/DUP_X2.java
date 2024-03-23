package ch7.instructions.stack.dup;

import ch7.instructions.base.NoOperandsInstruction;
import ch7.rtda.Fram;
import ch7.rtda.OperandStack;
import ch7.rtda.Slote;

public class DUP_X2 extends NoOperandsInstruction {
    /**
     * 前：.......,word3,word2,word1
     * 后：.......,word1,word3,word2,word1
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        Slote slot1=stack.popSlot();
        Slote slot2=stack.popSlot();
        Slote slot3=stack.popSlot();
        stack.pushSlot(slot1);
        stack.pushSlot(slot3);
        stack.pushSlot(slot2);
        stack.pushSlot(slot1);
    }
}
