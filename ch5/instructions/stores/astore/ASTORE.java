package ch5.instructions.stores.astore;

import ch5.instructions.base.Index8Instruction;
import ch5.instructions.stores.StoreTools;
import ch5.rtda.Fram;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/14:12
 * @Description:
 */
public class ASTORE extends Index8Instruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        StoreTools._astore(fram,this.index);
    }
}
