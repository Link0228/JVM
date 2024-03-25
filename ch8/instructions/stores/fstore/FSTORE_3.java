package ch8.instructions.stores.fstore;

import ch8.instructions.base.NoOperandsInstruction;
import ch8.instructions.stores.StoreTools;
import ch8.rtda.Fram;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/13:59
 * @Description:
 */
public class FSTORE_3 extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        StoreTools._fstore(fram,3);
    }
}
