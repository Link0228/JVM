package ch6.instructions.loads.iload;

import ch6.rtda.Fram;
import ch6.instructions.base.Index8Instruction;
import ch6.instructions.loads.LoadTools;

public class ILOAD extends Index8Instruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        LoadTools._iload(fram,(int)this.index);
    }
}
