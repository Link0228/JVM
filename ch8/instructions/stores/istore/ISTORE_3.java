package ch8.instructions.stores.istore;

import ch8.instructions.base.NoOperandsInstruction;
import ch8.instructions.stores.StoreTools;
import ch8.rtda.Fram;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/13:55
 * @Description:
 */
public class ISTORE_3 extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        StoreTools._istore(fram,3);
    }
}
