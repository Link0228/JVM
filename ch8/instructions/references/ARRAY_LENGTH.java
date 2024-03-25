package ch8.instructions.references;

import ch8.instructions.base.NoOperandsInstruction;
import ch8.rtda.Fram;
import ch8.rtda.OperandStack;
import ch8.rtda.heap.Objext;

public class ARRAY_LENGTH extends NoOperandsInstruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        Objext arrRef=stack.popRef();
        if(arrRef==null){
            System.out.println("java.lang.NullPointerException");
            System.exit(0);
        }
        int arrLen= arrRef.getArrayLength();
        stack.pushInt(arrLen);
    }
}
