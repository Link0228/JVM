package ch20.instructions.stores.lstore;

import ch20.instructions.base.NoOperandsInstruction;
import ch20.instructions.stores.StoreTools;
import ch20.rtda.Fram;

public class LSTORE_2 extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        StoreTools._lstore(fram,2);
    }
}
