package ch8.instructions.constants;

import ch8.instructions.base.Index16Instruction;
import ch8.rtda.Fram;

public class LDC_W extends Index16Instruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        LdcTools._ldc(fram,this.index);
    }
}
