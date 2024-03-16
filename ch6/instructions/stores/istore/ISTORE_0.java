package ch6.instructions.stores.istore;

import ch6.instructions.base.NoOperandsInstruction;
import ch6.instructions.stores.StoreTools;
import ch6.rtda.Fram;

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
