package ch7.instructions.references;

import ch7.instructions.base.Index16Instruction;
import ch7.instructions.base.MethodInvokeLogic;
import ch7.rtda.Fram;
import ch7.rtda.heap.*;

public class INVOKE_SPECIAL extends Index16Instruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        /*
        先拿到当前类、当前常量池、方法符号引用，然后解析符号引
        用，拿到解析后的类和方法。
         */
        Klass currentClass=fram.getMethod().getKlass();
        RTConstantPool cp=currentClass.getConstantPool();
        MethodRef methodRef=(MethodRef) cp.getConstant(this.index).getT();
        Klass resolvedClass=methodRef.resolvedClass();
        Method resolvedMethod=methodRef.resolvedMethod();
        /*
        假定从方法符号引用中解析出来的类是C，方法是M。如果M
        是构造函数，则声明M的类必须是C，否则抛出NoSuchMethodError
        异常。如果M是静态方法，则抛出IncompatibleClassChangeError异
        常。
         */
        if(resolvedMethod.getName().equals("<init>")&&resolvedMethod.getKlass()!=resolvedClass){
            System.out.println("java.lang.NoSuchMethodError");
            System.exit(0);
        }
        if(resolvedMethod.isStatic()){
            System.out.println("java.lang.IncompatibleClassChangeError");
            System.exit(0);
        }
        /*
        从操作数栈中弹出this引用，如果该引用是null，抛出
        NullPointerException异常。
         */
        Objext ref=fram.getOperandStack().getRefFromTop(resolvedMethod.getArgSlotCount()-1);
        if(ref==null){
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

        /*
        如果调用的是超类中的函数，但不是构造函数，且当前类的
        ACC_SUPER标志被设置，需要一个额外的过程查找最终要调
        用的方法；否则前面从方法符号引用中解析出来的方法就是要
        调用的方法
         */
        Method methodToBeInvoked=resolvedMethod;
        if(currentClass.isSuper()&&
            resolvedClass.isSuperClassOf(currentClass)&&
            !resolvedMethod.getName().equals("<init>")){
            methodToBeInvoked=MLK.lookupMethodInClass(currentClass.getSuperClass(),methodRef.getName(),methodRef.getDescriptor());
        }

        if(methodToBeInvoked==null|| methodToBeInvoked.isAbstract()){
            System.out.println("java.lang.AbstractMethodError");
            System.exit(0);
        }
        MethodInvokeLogic.invokeMethod(fram,methodToBeInvoked);
    }
}
