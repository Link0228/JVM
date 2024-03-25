package ch8.instructions.base;

import ch8.rtda.Fram;
import ch8.rtda.OperandStack;
import ch8.rtda.Slote;
import ch8.rtda.Thred;
import ch8.rtda.heap.Method;

public interface MethodInvokeLogic {
    static void invokeMethod(Fram invokerFrame, Method method){
        Thred thread=invokerFrame.getThread();
        Fram newFrame=thread.newFrame(method);
        thread.pushFram(newFrame);
        int argSlotSlot=method.getArgSlotCount();
        if(argSlotSlot>0){
            for(int i=argSlotSlot-1;i>=0;i--){
                Slote slot=invokerFrame.getOperandStack().popSlot();
                newFrame.getLocalVars().setSlot(i,slot);
            }
        }
        //hack!
        if(method.isNative()){
            if(method.getName().equals("registerNatives")){
                thread.popFram();
            }else{
                System.out.println("native method: "+method.getKlass().getName()
                        +" "+method.getName()+" "+method.getDescriptor());
                System.exit(0);
            }
        }
    }

    static void _println(OperandStack stack,String descriptor){
        switch (descriptor){
                case "(Z)V"->{System.out.println( stack.popInt() != 0);}
                case "(C)V"->{System.out.println( stack.popInt());}
                case "(B)V"->{System.out.println( stack.popInt());}
                case "(S)V"->{System.out.println( stack.popInt());}
                case "(I)V"->{System.out.println( stack.popInt());}
                case "(J)V"->{System.out.println( stack.popLong());}
                case "(F)V"->{System.out.println( stack.popFloat());}
                case "(D)V"->{System.out.println( stack.popDouble());}
                default -> {
                    System.out.println("println:"+descriptor);
                    System.exit(0);
                }
            }
            stack.popRef();
    }
}
