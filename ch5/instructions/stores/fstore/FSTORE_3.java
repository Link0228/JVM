package ch5.instructions.stores.fstore;

import ch5.instructions.base.NoOperandsInstruction;
import ch5.instructions.stores.StoreTools;
import ch5.rtda.Fram;

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
