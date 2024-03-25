package ch8.instructions.references;

import ch8.instructions.base.ClassInitLogic;
import ch8.instructions.base.Index16Instruction;
import ch8.rtda.Fram;
import ch8.rtda.LocalVars;
import ch8.rtda.OperandStack;
import ch8.rtda.heap.*;

public class PUT_STATIC extends Index16Instruction {
    /**
     * Set static field in class
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        Method currentMethod=fram.getMethod();
        Klass currentClass=currentMethod.getKlass();
        RTConstantPool cp=currentClass.getConstantPool();
        FieldRef fieldRef=(FieldRef) cp.getConstant(this.index).getT();
        Field field=fieldRef.resolvedField();
        Klass klass=field.getKlass();
        if(!klass.isInitStarted()){
            fram.revertNextPC();
            ClassInitLogic.initClass(fram.getThread(),klass);
            return;
        }
        if(!field.isStatic()){
            System.out.println("java.lang.IncompatibleClassChangeError");
            System.exit(0);
        }
        if(field.isFinal()){
            if(currentClass!=klass||!currentMethod.getName().equals("<clinit>")){
                System.out.println("java.lang.IllegalAccessError");
                System.exit(0);
            }
            //todo 静态常量初始化
        }
        String descriptor=field.getDescriptor();
        int slotId=field.getSlotId();
        LocalVars slots=klass.getStaticVars();
        OperandStack stack=fram.getOperandStack();
        switch (descriptor.charAt(0)){
            case 'Z', 'B', 'C', 'S', 'I'->{
                slots.setInt(slotId, stack.popInt());
            }
            case 'F'->{
                slots.setFloat(slotId, stack.popFloat());
            }
            case 'J'->{
                slots.setLong(slotId, stack.popLong());
            }
            case 'D'->{
                slots.setDouble(slotId,stack.popDouble());
            }
            case 'L','['->{
                slots.setRef(slotId,stack.popRef());
            }
        }
    }
}
