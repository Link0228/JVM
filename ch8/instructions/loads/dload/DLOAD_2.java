package ch8.instructions.loads.dload;

import ch8.instructions.base.NoOperandsInstruction;
import ch8.instructions.loads.LoadTools;
import ch8.rtda.Fram;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/10:51
 * @Description:
 */
public class DLOAD_2 extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        LoadTools._dload(fram,2);
    }
}
