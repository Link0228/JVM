package ch6.instructions.constants;

import ch6.instructions.base.Index16Instruction;
import ch6.rtda.Fram;

public class LDC_W extends Index16Instruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        LdcTools._ldc(fram,this.index);
    }
}
