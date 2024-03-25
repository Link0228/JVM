package ch8.instructions.references;

import ch8.instructions.base.Index16Instruction;
import ch8.rtda.Fram;
import ch8.rtda.OperandStack;
import ch8.rtda.heap.ClassRef;
import ch8.rtda.heap.Klass;
import ch8.rtda.heap.Objext;
import ch8.rtda.heap.RTConstantPool;

public class INSTANCE_OF extends Index16Instruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        Objext ref=stack.popRef();
        if (ref==null) {
            stack.pushInt(0);
            return;
        }
        RTConstantPool cp=fram.getMethod().getKlass().getConstantPool();
        ClassRef classRef=(ClassRef) cp.getConstant(this.index).getT();
        Klass klass=classRef.resolvedClass();
        if(ref.isInstanceOF(klass)){
            stack.pushInt(1);
        }else{
            stack.pushInt(0);
        }
    }
}
