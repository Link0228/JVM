package ch8.instructions.loads.lload;

import ch8.instructions.base.NoOperandsInstruction;
import ch8.instructions.loads.LoadTools;
import ch8.rtda.Fram;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/10:42
 * @Description:
 */
public class LLOAD_0 extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        LoadTools._lload(fram,0);
    }
}
