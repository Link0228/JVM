package ch8.instructions.references;

import ch8.instructions.base.ClassInitLogic;
import ch8.instructions.base.Index16Instruction;
import ch8.rtda.Fram;
import ch8.rtda.heap.ClassRef;
import ch8.rtda.heap.Klass;
import ch8.rtda.heap.Objext;
import ch8.rtda.heap.RTConstantPool;

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
        if(!klass.isInitStarted()){
            //由于此时指令已经执行到了一半，也
            //就是说当前帧的nextPC字段已经指向下一条指令，所以需要修改
            //nextPC，让它重新指向当前指令
            fram.revertNextPC();
            ClassInitLogic.initClass(fram.getThread(),klass);
            return;
        }
        if(klass.isInterface()||klass.isAbstract()){
            System.out.println("java.lang.InstantiationError");
            System.exit(0);
        }
        Objext ref=klass.newObjext();
        fram.getOperandStack().pushRef(ref);
    }
}
