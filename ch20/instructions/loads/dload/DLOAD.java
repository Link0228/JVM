package ch20.instructions.loads.dload;

import ch20.instructions.base.Index8Instruction;
import ch20.instructions.loads.LoadTools;
import ch20.rtda.Fram;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/10:50
 * @Description:
 */
public class DLOAD extends Index8Instruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        LoadTools._dload(fram,this.index);
    }
}
