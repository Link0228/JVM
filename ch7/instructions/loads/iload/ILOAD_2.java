package ch7.instructions.loads.iload;

import ch7.rtda.Fram;
import ch7.instructions.base.NoOperandsInstruction;
import ch7.instructions.loads.LoadTools;

public class ILOAD_2 extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        LoadTools._iload(fram,2);
    }
}
