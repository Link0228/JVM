package ch8.instructions.stores.aastore;

import ch8.instructions.base.NoOperandsInstruction;
import ch8.instructions.stores.StoreTools;
import ch8.rtda.Fram;
import ch8.rtda.OperandStack;
import ch8.rtda.heap.Objext;

public class CASTORE extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        int cval=stack.popInt();
        int index= stack.popInt();
        Objext arrRef=stack.popRef();
        StoreTools.checkNotNil(arrRef);
        char[] refs=arrRef.getChars();
        StoreTools.checkIndex(refs.length, index);
        refs[index]=(char)cval;
    }
}
