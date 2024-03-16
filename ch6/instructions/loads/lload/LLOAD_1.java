package ch6.instructions.loads.lload;

import ch6.instructions.base.NoOperandsInstruction;
import ch6.instructions.loads.LoadTools;
import ch6.rtda.Fram;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/10:42
 * @Description:
 */
public class LLOAD_1 extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        LoadTools._lload(fram,1);
    }
}
