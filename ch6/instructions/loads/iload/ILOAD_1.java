package ch6.instructions.loads.iload;

import ch6.rtda.Fram;
import ch6.instructions.base.NoOperandsInstruction;
import ch6.instructions.loads.LoadTools;

public class ILOAD_1 extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        LoadTools._iload(fram,1);
    }
}
