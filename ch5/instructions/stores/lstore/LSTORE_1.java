package ch5.instructions.stores.lstore;

import ch5.instructions.base.NoOperandsInstruction;
import ch5.instructions.stores.StoreTools;
import ch5.rtda.Fram;

public class LSTORE_1 extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        StoreTools._lstore(fram,1);
    }
}
