package ch6.instructions.stores.astore;

import ch6.instructions.base.NoOperandsInstruction;
import ch6.instructions.stores.StoreTools;
import ch6.rtda.Fram;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/14:13
 * @Description:
 */
public class ASTORE_3 extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        StoreTools._astore(fram,3);
    }
}
