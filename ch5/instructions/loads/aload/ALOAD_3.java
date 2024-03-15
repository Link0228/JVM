package ch5.instructions.loads.aload;

import ch5.instructions.base.NoOperandsInstruction;
import ch5.instructions.loads.LoadTools;
import ch5.rtda.Fram;

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
