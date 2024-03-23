package ch7.instructions.control;

import ch7.instructions.base.NoOperandsInstruction;
import ch7.rtda.Fram;
import ch7.rtda.Thred;

public class FRETURN extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        Thred thread=fram.getThread();
        Fram currentFrame=thread.popFram();
        Fram invokerFrame=thread.getCurrentFram();
        float retVal=currentFrame.getOperandStack().popFloat();
        invokerFrame.getOperandStack().pushFloat(retVal);
    }
}
