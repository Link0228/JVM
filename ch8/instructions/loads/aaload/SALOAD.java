package ch8.instructions.loads.aaload;

import ch8.instructions.base.NoOperandsInstruction;
import ch8.instructions.loads.LoadTools;
import ch8.rtda.Fram;
import ch8.rtda.OperandStack;
import ch8.rtda.heap.Objext;

public class SALOAD extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        int index=stack.popInt();
        Objext arrRef=stack.popRef();
        LoadTools.checkNotNil(arrRef);
        short[] refs=arrRef.getShorts();
        LoadTools.checkIndex(refs.length, index);
        stack.pushInt(refs[index]);
    }
}
