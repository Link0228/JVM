package ch7.instructions.loads.iload;

import ch7.rtda.Fram;
import ch7.instructions.base.Index8Instruction;
import ch7.instructions.loads.LoadTools;

public class ILOAD extends Index8Instruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        LoadTools._iload(fram,(int)this.index);
    }
}
