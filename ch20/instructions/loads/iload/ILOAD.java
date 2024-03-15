package ch20.instructions.loads.iload;

import ch20.rtda.Fram;
import ch20.instructions.base.Index8Instruction;
import ch20.instructions.loads.LoadTools;

public class ILOAD extends Index8Instruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        LoadTools._iload(fram,(int)this.index);
    }
}
