package ch5.instructions.math.iinc;

import ch5.instructions.base.BytecodeReader;
import ch5.instructions.base.Instruction;
import ch5.rtda.Fram;
import ch5.rtda.LocalVars;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/9:53
 * @Description:
 */
public class IINC extends Instruction {
    public int index;
    public int iconst;

    /**
     * @param reader
     */
    @Override
    public void fetchOperands(BytecodeReader reader) {
        index=reader.readUint8();
        iconst=(int)reader.readUint8();
    }

    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        LocalVars localVars=fram.getLocalVars();
        int val=localVars.getInt(index);
        val+=iconst;
        localVars.setInt(index,val);
    }
}
