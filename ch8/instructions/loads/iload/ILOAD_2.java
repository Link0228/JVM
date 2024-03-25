package ch8.instructions.loads.iload;

import ch8.rtda.Fram;
import ch8.instructions.base.NoOperandsInstruction;
import ch8.instructions.loads.LoadTools;

public class ILOAD_2 extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        LoadTools._iload(fram,2);
    }
}
