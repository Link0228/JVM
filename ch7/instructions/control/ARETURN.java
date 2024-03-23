package ch7.instructions.control;

import ch7.instructions.base.NoOperandsInstruction;
import ch7.rtda.Fram;
import ch7.rtda.Thred;
import ch7.rtda.heap.Objext;

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
