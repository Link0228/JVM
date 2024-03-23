package ch7.instructions.loads.dload;

import ch7.instructions.base.NoOperandsInstruction;
import ch7.instructions.loads.LoadTools;
import ch7.rtda.Fram;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/10:52
 * @Description:
 */
public class DLOAD_3 extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        LoadTools._dload(fram,3);
    }
}
