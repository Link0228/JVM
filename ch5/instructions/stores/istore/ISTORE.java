package ch5.instructions.stores.istore;

import ch5.instructions.base.Index8Instruction;
import ch5.instructions.stores.StoreTools;
import ch5.rtda.Fram;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/13:52
 * @Description:
 */
public class ISTORE extends Index8Instruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        StoreTools._istore(fram,this.index);
    }
}
