package ch8.instructions.control;

import ch8.instructions.base.NoOperandsInstruction;
import ch8.rtda.Fram;
import ch8.rtda.Thred;
import ch8.rtda.heap.Objext;

public class ARETURN extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        Thred thread=fram.getThread();
        Fram currentFrame=thread.popFram();
        Fram invokerFrame=thread.getCurrentFram();
        Objext retRef=currentFrame.getOperandStack().popRef();
        invokerFrame.getOperandStack().pushRef(retRef);
    }
}
