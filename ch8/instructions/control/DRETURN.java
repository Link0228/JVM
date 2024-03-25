package ch8.instructions.control;

import ch8.instructions.base.NoOperandsInstruction;
import ch8.rtda.Fram;
import ch8.rtda.Thred;

public class DRETURN extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        Thred thread=fram.getThread();
        Fram currentFrame=thread.popFram();
        Fram invokerFrame=thread.getCurrentFram();
        double retVal=currentFrame.getOperandStack().popDouble();
        invokerFrame.getOperandStack().pushDouble(retVal);
    }
}
