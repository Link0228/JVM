package ch8.instructions.constants;

import ch8.instructions.base.Index8Instruction;
import ch8.rtda.Fram;

public class LDC extends Index8Instruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        LdcTools._ldc(fram,this.index);
    }
}
