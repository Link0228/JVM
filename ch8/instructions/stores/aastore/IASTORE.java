package ch8.instructions.stores.aastore;

import ch8.instructions.base.NoOperandsInstruction;
import ch8.instructions.stores.StoreTools;
import ch8.rtda.Fram;
import ch8.rtda.OperandStack;
import ch8.rtda.heap.Objext;

public class IASTORE extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        int ival=stack.popInt();
        int index= stack.popInt();
        Objext arrRef=stack.popRef();
        StoreTools.checkNotNil(arrRef);
        int[] refs=arrRef.getInts();
        StoreTools.checkIndex(refs.length, index);
        refs[index]=ival;
    }
}
