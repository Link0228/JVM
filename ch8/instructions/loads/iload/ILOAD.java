package ch8.instructions.loads.iload;

import ch8.rtda.Fram;
import ch8.instructions.base.Index8Instruction;
import ch8.instructions.loads.LoadTools;

public class ILOAD extends Index8Instruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        LoadTools._iload(fram,(int)this.index);
    }
}
