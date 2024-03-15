package ch5.instructions.loads.iload;

import ch5.rtda.Fram;
import ch5.instructions.base.Index8Instruction;
import ch5.instructions.loads.LoadTools;

public class ILOAD extends Index8Instruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        LoadTools._iload(fram,(int)this.index);
    }
}
