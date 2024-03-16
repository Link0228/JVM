package ch6.instructions.loads.dload;

import ch6.instructions.base.NoOperandsInstruction;
import ch6.instructions.loads.LoadTools;
import ch6.rtda.Fram;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/10:51
 * @Description:
 */
public class DLOAD_0 extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        LoadTools._dload(fram,0);
    }
}
