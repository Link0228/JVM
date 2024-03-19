package ch6.instructions.references;

import ch6.instructions.base.Index16Instruction;
import ch6.rtda.Fram;
import ch6.rtda.LocalVars;
import ch6.rtda.OperandStack;
import ch6.rtda.heap.Field;
import ch6.rtda.heap.FieldRef;
import ch6.rtda.heap.Objext;
import ch6.rtda.heap.RTConstantPool;

public class GET_FIELD extends Index16Instruction {
    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        RTConstantPool cp=fram.getMethod().getKlass().getConstantPool();
        FieldRef fieldRef=(FieldRef) cp.getConstant(this.index).getT();
        Field field=fieldRef.resolvedField();
        if(field.isStatic()){
            System.out.println("java.lang.IncompatibleClassChangeError");
            System.exit(0);
        }
        OperandStack stack=fram.getOperandStack();
        Objext ref=stack.popRef();
        if(ref==null){
            System.out.println("java.lang.NullPointerException");
            System.exit(0);
        }
        String descriptor= field.getDescriptor();;
        int slotId=field.getSlotId();
        LocalVars slots=ref.getFields();
        switch (descriptor.charAt(0)){
            case 'Z', 'B', 'C', 'S', 'I'->{
                stack.pushInt(slots.getInt(slotId));
            }
            case 'F'->{
                stack.pushFloat(slots.getFloat(slotId));
            }
            case 'J'->{
                stack.pushLong(slots.getLong(slotId));
            }
            case 'D'->{
                stack.pushDouble(slots.getDouble(slotId));
            }
            case 'L','['->{
                stack.pushRef(slots.getRef(slotId));
            }
        }
    }
}
