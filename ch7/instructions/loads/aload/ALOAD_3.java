package ch7.instructions.loads.aload;

import ch7.instructions.base.NoOperandsInstruction;
import ch7.instructions.loads.LoadTools;
import ch7.rtda.Fram;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/10:56
 * @Description:
 */
public class ALOAD_3 extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        LoadTools._aload(fram,3);
    }
}
