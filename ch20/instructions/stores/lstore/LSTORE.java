package ch20.instructions.stores.lstore;

import ch20.instructions.stores.StoreTools;
import ch20.rtda.Fram;
import ch20.instructions.base.Index8Instruction;

public class LSTORE extends Index8Instruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        StoreTools._lstore(fram,(int)this.index);
    }
}
