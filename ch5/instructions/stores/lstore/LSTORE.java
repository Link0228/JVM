package ch5.instructions.stores.lstore;

import ch5.instructions.stores.StoreTools;
import ch5.rtda.Fram;
import ch5.instructions.base.Index8Instruction;

public class LSTORE extends Index8Instruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        StoreTools._lstore(fram,(int)this.index);
    }
}
