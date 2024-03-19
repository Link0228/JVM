package ch6.instructions.references;

import ch6.instructions.base.Index16Instruction;
import ch6.rtda.Fram;
import ch6.rtda.heap.ClassRef;
import ch6.rtda.heap.Klass;
import ch6.rtda.heap.Objext;
import ch6.rtda.heap.RTConstantPool;

public class NEW extends Index16Instruction {
    /**
     * Create new object
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        RTConstantPool cp=fram.getMethod().getKlass().getConstantPool();
        ClassRef classRef=(ClassRef) cp.getConstant(this.index).getT();
        Klass klass=classRef.resolvedClass();
        if(klass.isInterface()||klass.isAbstract()){
            System.out.println("java.lang.InstantiationError");
            System.exit(0);
        }
        Objext ref=klass.newObjext();
        fram.getOperandStack().pushRef(ref);
    }
}
