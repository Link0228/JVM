package ch20.instructions.stores.dstore;

import ch20.instructions.base.Index8Instruction;
import ch20.instructions.stores.StoreTools;
import ch20.rtda.Fram;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/14:05
 * @Description:
 */
public class DSTORE extends Index8Instruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        StoreTools._dstore(fram,this.index);
    }
}
