package ch7.instructions.constants;

import ch7.classfile.constantinfo.ConstantInfo;
import ch7.instructions.base.Index16Instruction;
import ch7.rtda.Fram;
import ch7.rtda.OperandStack;
import ch7.rtda.heap.RTConstantPool;

public class LDC2_W extends Index16Instruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        OperandStack stack=fram.getOperandStack();
        RTConstantPool cp=fram.getMethod().getKlass().getConstantPool();
        int type=cp.getConstant(index).getTag();
        switch (type) {
            case ConstantInfo.CONSTANT_Long -> {
                stack.pushLong((long) cp.getConstant(index).getT());
            }
            case ConstantInfo.CONSTANT_Double -> {
                stack.pushDouble((double) cp.getConstant(index).getT());
            }
            default -> {
                System.out.println("java.lang.ClassFormatError");
                System.exit(0);
            }
        }
    }
}
