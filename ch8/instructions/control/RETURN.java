package ch8.instructions.control;

import ch8.instructions.base.NoOperandsInstruction;
import ch8.rtda.Fram;

public class RETURN extends NoOperandsInstruction {
    /**
     * 从jvm栈中弹出当前帧
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        fram.getThread().popFram();
    }
}
