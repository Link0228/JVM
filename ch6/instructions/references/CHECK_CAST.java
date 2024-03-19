package ch6.instructions.references;

import ch6.instructions.base.Index16Instruction;
import ch6.rtda.Fram;
import ch6.rtda.OperandStack;
import ch6.rtda.heap.ClassRef;
import ch6.rtda.heap.Klass;
import ch6.rtda.heap.Objext;
import ch6.rtda.heap.RTConstantPool;

public class CHECK_CAST extends Index16Instruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        Objext ref=stack.popRef();
        stack.pushRef(ref);
        if(ref==null){
            return;
        }
        RTConstantPool cp=fram.getMethod().getKlass().getConstantPool();
        ClassRef classRef=(ClassRef) cp.getConstant(this.index).getT();
        Klass klass=classRef.resolvedClass();
        if(!ref.isInstanceOF(klass)){
            System.out.println("java.lang.ClassCastException");
            System.exit(0);
        }
    }
}
