package ch7.instructions.constants;

import ch7.classfile.constantinfo.ConstantInfo;
import ch7.rtda.Fram;
import ch7.rtda.OperandStack;
import ch7.rtda.heap.RTConstantPool;

public class LdcTools {
    public static void _ldc(Fram fram,int index){
        OperandStack stack=fram.getOperandStack();
        RTConstantPool cp=fram.getMethod().getKlass().getConstantPool();
        int type=cp.getConstant(index).getTag();
        switch (type){
            case ConstantInfo.CONSTANT_Integer->{
                stack.pushInt((int)cp.getConstant(index).getT());
            }
            case ConstantInfo.CONSTANT_Float -> {
                stack.pushFloat((float)cp.getConstant(index).getT() );
            }
//todo            case ConstantInfo.CONSTANT_String -> {
//
//            }
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
