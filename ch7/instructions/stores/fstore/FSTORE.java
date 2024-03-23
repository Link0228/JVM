package ch7.instructions.stores.fstore;

import ch7.instructions.base.Index8Instruction;
import ch7.instructions.base.NoOperandsInstruction;
import ch7.instructions.stores.StoreTools;
import ch7.rtda.Fram;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/13:58
 * @Description:
 */
public class FSTORE extends Index8Instruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        StoreTools._fstore(fram,this.index);
    }
}
