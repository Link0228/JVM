package ch20.instructions.loads.lload;

import ch20.instructions.base.Index8Instruction;
import ch20.instructions.loads.LoadTools;
import ch20.rtda.Fram;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/10:35
 * @Description:
 */
public class LLOAD extends Index8Instruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        LoadTools._lload(fram,this.index);
    }
}
