package ch8.instructions.references;

import ch8.instructions.base.Index16Instruction;
import ch8.rtda.Fram;
import ch8.rtda.OperandStack;
import ch8.rtda.heap.ClassRef;
import ch8.rtda.heap.Klass;
import ch8.rtda.heap.Objext;
import ch8.rtda.heap.RTConstantPool;

public class ANEW_ARRAY extends Index16Instruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        RTConstantPool cp=fram.getMethod().getKlass().getConstantPool();
        ClassRef classRef=(ClassRef) cp.getConstant(this.index).getT();
        Klass componentClass=classRef.resolvedClass();
        OperandStack stack=fram.getOperandStack();
        int count=stack.popInt();
        if(count<0){
            System.out.println("java.lang.NegativeArraySizeException");
            System.exit(0);
        }
        Klass arrClass=componentClass.getArrayClass();
        Objext arr=arrClass.newArray(count);
        stack.pushRef(arr);
    }
}
