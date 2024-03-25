package ch8.instructions.references;

import ch8.instructions.base.BytecodeReader;
import ch8.instructions.base.Instruction;
import ch8.instructions.base.MethodInvokeLogic;
import ch8.rtda.Fram;
import ch8.rtda.heap.*;

public class INVOKE_INTERFACE extends Instruction {
    private int index;
    // count uint8
    // zero uint8

    /**
     * @param reader
     */
    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.index=reader.readUint16();
        reader.readUint8(); // count
        reader.readUint8(); // must be 0
    }

    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        /*
        先从运行时常量池中拿到并解析接口方法符号引用，如果解
        析后的方法是静态方法或私有方法，则抛出
        IncompatibleClassChangeError异常。
         */
        RTConstantPool cp=fram.getMethod().getKlass().getConstantPool();
        InterfaceMethodRef methodRef=(InterfaceMethodRef) cp.getConstant(this.index).getT();
        Method resolvedMethod=methodRef.resolvedInterfaceMethod();
        if(resolvedMethod.isStatic()||resolvedMethod.isPrivate()){
            System.out.println("java.lang.IncompatibleClassChangeError");
            System.exit(0);
        }
        /*
        从操作数栈中弹出this引用，如果引用是null，则抛出
        NullPointerException异常。如果引用所指对象的类没有实现解析出
        来的接口，则抛出IncompatibleClassChangeError异常。
         */
        Objext ref=fram.getOperandStack().getRefFromTop(resolvedMethod.getArgSlotCount()-1);
        if(ref==null){
            System.out.println("java.lang.NullPointerException");
            System.exit(0);
        }
        if(!ref.getKlass().isImplements(methodRef.resolvedClass())){
            System.out.println("java.lang.IncompatibleClassChangeError");
            System.exit(0);
        }
        /*
        查找最终要调用的方法。如果找不到，或者找到的方法是抽象
        的，则抛出Abstract-MethodError异常。如果找到的方法不是public，
        则抛出IllegalAccessError异常。
         */
        Method methodToBeInvoked=MLK.lookupMethodInClass(ref.getKlass(),methodRef.getName(),methodRef.getDescriptor());
        if(methodToBeInvoked==null||methodToBeInvoked.isAbstract()){
            System.out.println("java.lang.AbstractMethodError");
            System.exit(0);
        }
        if(!methodToBeInvoked.isPublic()){
            System.out.println("java.lang.IllegalAccessError");
            System.exit(0);
        }
        MethodInvokeLogic.invokeMethod(fram,methodToBeInvoked);
    }
}
