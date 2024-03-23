package ch7.instructions.constants;

import ch7.instructions.base.Index8Instruction;
import ch7.rtda.Fram;

public class LDC extends Index8Instruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        LdcTools._ldc(fram,this.index);
    }
}
