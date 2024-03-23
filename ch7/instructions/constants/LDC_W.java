package ch7.instructions.constants;

import ch7.instructions.base.Index16Instruction;
import ch7.rtda.Fram;

public class LDC_W extends Index16Instruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        LdcTools._ldc(fram,this.index);
    }
}
