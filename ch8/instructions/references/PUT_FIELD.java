package ch8.instructions.references;

import ch8.instructions.base.Index16Instruction;
import ch8.rtda.Fram;
import ch8.rtda.OperandStack;
import ch8.rtda.heap.*;

public class PUT_FIELD extends Index16Instruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        Method currentMethod=fram.getMethod();
        Klass currentClass=currentMethod.getKlass();
        RTConstantPool cp=currentClass.getConstantPool();
        FieldRef fieldRef=(FieldRef) cp.getConstant(this.index).getT();
        Field field=fieldRef.resolvedField();
        if(field.isStatic()){
            System.out.println("java.lang.IncompatibleClassChangeError");
            System.exit(0);
        }
        if(field.isFinal()){
            if(currentClass!=field.getKlass()||!currentMethod.getName().equals("<init>")){
                System.out.println("java.lang.IllegalAccessError");
                System.exit(0);
            }
            //todo 静态常量初始化
        }
        String descriptor=field.getDescriptor();
        int slotId=field.getSlotId();
        OperandStack stack=fram.getOperandStack();
        switch (descriptor.charAt(0)){
            case 'Z', 'B', 'C', 'S', 'I'->{
                int val=stack.popInt();
                Objext ref=stack.popRef();
                if(ref==null){
                    System.out.println("java.lang.NullPointerException");
                    System.exit(0);
                }
                ref.getFields().setInt(slotId,val);
            }
            case 'F'->{
                float val=stack.popFloat();
                Objext ref=stack.popRef();
                if(ref==null){
                    System.out.println("java.lang.NullPointerException");
                    System.exit(0);
                }
                ref.getFields().setFloat(slotId,val);
            }
            case 'J'->{
                long val=stack.popLong();
                Objext ref=stack.popRef();
                if(ref==null){
                    System.out.println("java.lang.NullPointerException");
                    System.exit(0);
                }
                ref.getFields().setLong(slotId,val);
            }
            case 'D'->{
                double val=stack.popFloat();
                Objext ref=stack.popRef();
                if(ref==null){
                    System.out.println("java.lang.NullPointerException");
                    System.exit(0);
                }
                ref.getFields().setDouble(slotId,val);
            }
            case 'L','['->{
                Objext val=stack.popRef();
                Objext ref=stack.popRef();
                if(ref==null){
                    System.out.println("java.lang.NullPointerException");
                    System.exit(0);
                }
                ref.getFields().setRef(slotId,val);
            }
        }
    }
}
