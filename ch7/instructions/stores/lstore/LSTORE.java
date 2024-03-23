package ch7.instructions.stores.lstore;

import ch7.instructions.stores.StoreTools;
import ch7.rtda.Fram;
import ch7.instructions.base.Index8Instruction;

public class LSTORE extends Index8Instruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        StoreTools._lstore(fram,(int)this.index);
    }
}
