package ch6.instructions.stores.lstore;

import ch6.instructions.stores.StoreTools;
import ch6.rtda.Fram;
import ch6.instructions.base.Index8Instruction;

public class LSTORE extends Index8Instruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        StoreTools._lstore(fram,(int)this.index);
    }
}
