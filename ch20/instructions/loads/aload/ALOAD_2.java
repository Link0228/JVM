package ch20.instructions.loads.aload;

import ch20.instructions.base.NoOperandsInstruction;
import ch20.instructions.loads.LoadTools;
import ch20.rtda.Fram;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/10:56
 * @Description:
 */
public class ALOAD_2 extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        LoadTools._aload(fram,2);
    }
}
