package ch8.instructions.references;

import ch8.instructions.base.ClassInitLogic;
import ch8.instructions.base.Index16Instruction;
import ch8.instructions.base.MethodInvokeLogic;
import ch8.rtda.Fram;
import ch8.rtda.heap.Klass;
import ch8.rtda.heap.Method;
import ch8.rtda.heap.MethodRef;
import ch8.rtda.heap.RTConstantPool;

public class INVOKE_STATIC extends Index16Instruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        RTConstantPool cp=fram.getMethod().getKlass().getConstantPool();
        MethodRef methodRef=(MethodRef) cp.getConstant(this.index).getT();
        Method resolvedMethod=methodRef.resolvedMethod();
        if(!resolvedMethod.isStatic()){
            System.out.println("java.lang.IncompatibleClassChangeError");
            System.exit(0);
        }
        Klass klass=resolvedMethod.getKlass();
        if(!klass.isInitStarted()){
            fram.revertNextPC();
            ClassInitLogic.initClass(fram.getThread(),klass);
            return;
        }
        MethodInvokeLogic.invokeMethod(fram,resolvedMethod);
    }
}
