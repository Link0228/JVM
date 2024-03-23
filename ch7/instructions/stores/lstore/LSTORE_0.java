package ch7.instructions.stores.lstore;

import ch7.instructions.base.NoOperandsInstruction;
import ch7.instructions.stores.StoreTools;
import ch7.rtda.Fram;

public class LSTORE_0 extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        StoreTools._lstore(fram,0);
    }
}
