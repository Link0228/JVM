package ch5.instructions.stores.dstore;

import ch5.instructions.base.NoOperandsInstruction;
import ch5.instructions.stores.StoreTools;
import ch5.rtda.Fram;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/14:10
 * @Description:
 */
public class DSTORE_2 extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        StoreTools._dstore(fram,2);
    }
}
