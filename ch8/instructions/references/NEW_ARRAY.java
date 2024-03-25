package ch8.instructions.references;

import ch8.instructions.base.BytecodeReader;
import ch8.instructions.base.Instruction;
import ch8.rtda.Fram;
import ch8.rtda.OperandStack;
import ch8.rtda.heap.Klass;
import ch8.rtda.heap.KlassLoader;
import ch8.rtda.heap.Objext;

public class NEW_ARRAY extends Instruction {
    int atype;
    /**
     * @param reader
     */
    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.atype=reader.readUint8();
    }

    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        int count=stack.popInt();
        if(count<0){
            System.out.println("java.lang.NegativeArraySizeException");
            System.exit(0);
        }
        KlassLoader classLoader=fram.getMethod().getKlass().getLoader();
        Klass arrClass=Atype.getPrimitiveArrayClass(classLoader,this.atype);
        Objext arr=arrClass.newArray(count);
        stack.pushRef(arr);
    }
}
