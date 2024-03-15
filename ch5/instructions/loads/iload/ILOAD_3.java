package ch5.instructions.loads.iload;

import ch5.rtda.Fram;
import ch5.instructions.base.NoOperandsInstruction;
import ch5.instructions.loads.LoadTools;

public class ILOAD_3 extends NoOperandsInstruction
{
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        LoadTools._iload(fram,3);
    }
}
