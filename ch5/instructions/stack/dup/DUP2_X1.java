package ch5.instructions.stack.dup;

import ch5.instructions.base.NoOperandsInstruction;
import ch5.rtda.Fram;
import ch5.rtda.OperandStack;
import ch5.rtda.Slote;

public class DUP2_X1 extends NoOperandsInstruction {
    /**
     * 前：......,word3,word2,word1
     * 后：.......,word2,word1,word3,word2,word1
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        Slote slot1=stack.popSlot();
        Slote slot2=stack.popSlot();
        Slote slot3=stack.popSlot();
        stack.pushSlot(slot2);
        stack.pushSlot(slot1);
        stack.pushSlot(slot3);
        stack.pushSlot(slot2);
        stack.pushSlot(slot1);
    }
}
