package ch8.instructions.references;

import ch8.instructions.base.Index16Instruction;
import ch8.instructions.base.MethodInvokeLogic;
import ch8.rtda.Fram;
import ch8.rtda.OperandStack;
import ch8.rtda.heap.*;

public class INVOKE_VIRTUAL extends Index16Instruction {
    /**
     * hack!
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        // todo vtable优化
        Klass currentClass=fram.getMethod().getKlass();
        RTConstantPool cp=currentClass.getConstantPool();
        MethodRef methodRef=(MethodRef) cp.getConstant(this.index).getT();
        Method resolvedMethod=methodRef.resolvedMethod();
        if(resolvedMethod.isStatic()){
            System.out.println("java.lang.IncompatibleClassChangeError");
            System.exit(0);
        }
        Objext ref=fram.getOperandStack().getRefFromTop(resolvedMethod.getArgSlotCount()-1);
        if(ref==null){
            // hack!
            if(methodRef.getName().equals("println")){
                MethodInvokeLogic._println(fram.getOperandStack(), methodRef.getDescriptor());
                return;
            }
            System.out.println("java.lang.NullPointerException");
            System.exit(0);
        }
        if(resolvedMethod.isProtected()&&
                resolvedMethod.getKlass().isSuperClassOf(currentClass)&&
                !resolvedMethod.getKlass().getPackageName().equals(currentClass.getPackageName())&&
                ref.getKlass()!=currentClass&&
                !ref.getKlass().isSubClassOf(currentClass)){
            System.out.println("java.lang.IllegalAccessError");
            System.exit(0);
        }
        Method methodToBeInvoked=MLK.lookupMethodInClass(ref.getKlass(),methodRef.getName(), methodRef.getDescriptor());
        if(methodToBeInvoked==null||methodToBeInvoked.isAbstract()){
            System.out.println("java.lang.AbstractMethodError");
            System.exit(0);
        }
        MethodInvokeLogic.invokeMethod(fram,methodToBeInvoked);
//        RTConstantPool cp=fram.getMethod().getKlass().getConstantPool();
//        MethodRef methodRef=(MethodRef) cp.getConstant(this.index).getT();
//        if(methodRef.getName().equals("println" )){
//            OperandStack stack=fram.getOperandStack();
//            switch (methodRef.getDescriptor()){
//                case "(Z)V"->{System.out.println( stack.popInt() != 0);}
//                case "(C)V"->{System.out.println( stack.popInt());}
//                case "(B)V"->{System.out.println( stack.popInt());}
//                case "(S)V"->{System.out.println( stack.popInt());}
//                case "(I)V"->{System.out.println( stack.popInt());}
//                case "(J)V"->{System.out.println( stack.popLong());}
//                case "(F)V"->{System.out.println( stack.popFloat());}
//                case "(D)V"->{System.out.println( stack.popDouble());}
//                default -> {
//                    System.out.println("println:"+methodRef.getDescriptor());
//                    System.exit(0);
//                }
//            }
//            stack.popRef();
//        }
    }
}
