package ch7.instructions.stores.astore;

import ch7.instructions.base.NoOperandsInstruction;
import ch7.instructions.stores.StoreTools;
import ch7.rtda.Fram;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/14:13
 * @Description:
 */
public class ASTORE_0 extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        StoreTools._astore(fram,0);
    }
}
