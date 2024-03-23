package ch7.instructions.control;

import ch7.instructions.base.NoOperandsInstruction;
import ch7.rtda.Fram;
import ch7.rtda.Thred;

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
