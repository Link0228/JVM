package ch5.instructions.loads.fload;

import ch5.instructions.base.Index8Instruction;
import ch5.instructions.loads.LoadTools;
import ch5.rtda.Fram;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/10:47
 * @Description:
 */
public class FLOAD extends Index8Instruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        LoadTools._fload(fram,this.index);
    }
}
