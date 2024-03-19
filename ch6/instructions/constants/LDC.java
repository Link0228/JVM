package ch6.instructions.constants;

import ch6.instructions.base.Index8Instruction;
import ch6.rtda.Fram;

public class LDC extends Index8Instruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        LdcTools._ldc(fram,this.index);
    }
}
