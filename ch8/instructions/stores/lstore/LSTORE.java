package ch8.instructions.stores.lstore;

import ch8.instructions.stores.StoreTools;
import ch8.rtda.Fram;
import ch8.instructions.base.Index8Instruction;

public class LSTORE extends Index8Instruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        StoreTools._lstore(fram,(int)this.index);
    }
}
