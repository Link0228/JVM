package ch8.instructions.constants;

import ch8.classfile.constantinfo.ConstantInfo;
import ch8.rtda.Fram;
import ch8.rtda.OperandStack;
import ch8.rtda.heap.Klass;
import ch8.rtda.heap.Objext;
import ch8.rtda.heap.RTConstantPool;
import ch8.rtda.heap.StringPool;

public class LdcTools {
    public static void _ldc(Fram fram,int index){
        OperandStack stack=fram.getOperandStack();
        Klass klass=fram.getMethod().getKlass();
        RTConstantPool cp=klass.getConstantPool();
        int type=cp.getConstant(index).getTag();
        switch (type){
            case ConstantInfo.CONSTANT_Integer->{
                stack.pushInt((int)cp.getConstant(index).getT());
            }
            case ConstantInfo.CONSTANT_Float -> {
                stack.pushFloat((float)cp.getConstant(index).getT() );
            }
            case ConstantInfo.CONSTANT_String -> {
                Objext internedStr= new StringPool().jString(klass.getLoader(),(String)cp.getConstant(index).getT());
                stack.pushRef(internedStr);
            }
//todo            case ConstantInfo.CONSTANT_Class -> {
//
//            }
            default -> {
                System.out.println("todo: ldc!");
                System.exit(0);
            }
        }
    }
}
