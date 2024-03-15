package ch5.instructions.loads.aload;

import ch5.instructions.base.NoOperandsInstruction;
import ch5.instructions.loads.LoadTools;
import ch5.rtda.Fram;
import ch5.rtda.LocalVars;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/10:55
 * @Description:
 */
public class ALOAD_0 extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        LoadTools._aload(fram,0);
    }
}
