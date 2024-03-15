package ch20.instructions.stores.fstore;

import ch20.instructions.base.NoOperandsInstruction;
import ch20.instructions.stores.StoreTools;
import ch20.rtda.Fram;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/13:59
 * @Description:
 */
public class FSTORE_1 extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        StoreTools._fstore(fram,1);
    }
}
