package ch6.instructions.references;

import ch6.instructions.base.Index16Instruction;
import ch6.rtda.Fram;
import ch6.rtda.OperandStack;
import ch6.rtda.heap.MethodRef;
import ch6.rtda.heap.RTConstantPool;

public class INVOKE_VIRTUAL extends Index16Instruction {
    /**
     * hack!
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        RTConstantPool cp=fram.getMethod().getKlass().getConstantPool();
        MethodRef methodRef=(MethodRef) cp.getConstant(this.index).getT();
        if(methodRef.getName().equals("println" )){
            OperandStack stack=fram.getOperandStack();
            switch (methodRef.getDescriptor()){
                case "(Z)V"->{System.out.println( stack.popInt() != 0);}
                case "(C)V"->{System.out.println( stack.popInt());}
                case "(B)V"->{System.out.println( stack.popInt());}
                case "(S)V"->{System.out.println( stack.popInt());}
                case "(I)V"->{System.out.println( stack.popInt());}
                case "(J)V"->{System.out.println( stack.popLong());}
                case "(F)V"->{System.out.println( stack.popFloat());}
                case "(D)V"->{System.out.println( stack.popDouble());}
                default -> {
                    System.out.println("println:"+methodRef.getDescriptor());
                    System.exit(0);
                }
            }
            stack.popRef();
        }
    }
}
