package ch20.instructions.loads.iload;

import ch20.rtda.Fram;
import ch20.instructions.base.NoOperandsInstruction;
import ch20.instructions.loads.LoadTools;

public class ILOAD_1 extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        LoadTools._iload(fram,1);
    }
}
