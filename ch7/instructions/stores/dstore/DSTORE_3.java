package ch7.instructions.stores.dstore;

import ch7.instructions.base.NoOperandsInstruction;
import ch7.instructions.stores.StoreTools;
import ch7.rtda.Fram;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/14:10
 * @Description:
 */
public class DSTORE_3 extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        StoreTools._dstore(fram,3);
    }
}
