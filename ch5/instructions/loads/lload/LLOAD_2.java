package ch5.instructions.loads.lload;

import ch5.instructions.base.NoOperandsInstruction;
import ch5.instructions.loads.LoadTools;
import ch5.rtda.Fram;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/10:42
 * @Description:
 */
public class LLOAD_2 extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        LoadTools._lload(fram,2);
    }
}
