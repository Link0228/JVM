package ch20.instructions.stores.istore;

import ch20.instructions.base.NoOperandsInstruction;
import ch20.instructions.stores.StoreTools;
import ch20.rtda.Fram;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/13:55
 * @Description:
 */
public class ISTORE_0 extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        StoreTools._istore(fram,0);
    }
}
