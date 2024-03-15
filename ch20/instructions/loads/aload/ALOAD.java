package ch20.instructions.loads.aload;

import ch20.instructions.base.Index8Instruction;
import ch20.instructions.loads.LoadTools;
import ch20.rtda.Fram;
import ch20.rtda.LocalVars;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/10:55
 * @Description:
 */
public class ALOAD extends Index8Instruction {

    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        LoadTools._aload(fram,this.index);
    }
}
