package ch20.instructions.loads.dload;

import ch20.instructions.base.NoOperandsInstruction;
import ch20.instructions.loads.LoadTools;
import ch20.rtda.Fram;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/10:51
 * @Description:
 */
public class DLOAD_1 extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        LoadTools._dload(fram,1);
    }
}
