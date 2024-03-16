package ch6.instructions.stores.lstore;

import ch6.instructions.base.NoOperandsInstruction;
import ch6.instructions.stores.StoreTools;
import ch6.rtda.Fram;

public class LSTORE_3 extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        StoreTools._lstore(fram,3);
    }
}
