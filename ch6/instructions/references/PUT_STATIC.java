package ch6.instructions.references;

import ch6.instructions.base.Index16Instruction;
import ch6.rtda.Fram;
import ch6.rtda.LocalVars;
import ch6.rtda.OperandStack;
import ch6.rtda.heap.*;

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
        //todo 类初始化 chapter7
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
