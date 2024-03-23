package ch7;

import ch7.instructions.base.BytecodeReader;
import ch7.instructions.base.Instruction;
import ch7.rtda.Fram;
import ch7.rtda.Thred;
import ch7.classfile.MemberInfo;
import ch7.classfile.attributeinfo.CodeAttribute;
import ch7.rtda.heap.Method;

import java.io.Closeable;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/15:04
 * @Description:
 */
public class Interpreter {
    public static void interpret(Method method,boolean logInst){
        Thred thread=new Thred();
        Fram frame=thread.newFrame(method);
        thread.pushFram(frame);
        try {
            loop(thread,logInst);
        } catch (Exception e) {
            logFrames(thread);
            System.exit(0);
        }
    }

    public static void loop(Thred thread,boolean logInst){
        BytecodeReader reader=new BytecodeReader();
        while(true){
           Fram frame=thread.getCurrentFram();
           int pc=frame.getNextPC();
           thread.setPc(pc);
           //decode
            reader.reset(frame.getMethod().getCode(),pc);
            int opcode=reader.readUint8();
            Instruction inst=Instruction.newInstruction(opcode);
            inst.fetchOperands(reader);
            frame.setNextPC(reader.getPc());
            if(logInst){
                logInstruction(frame,inst);
            }
            //execute
            inst.execute(frame);
            if(thread.isStackEmpty()){
                break;
            }
        }
    }

    public static void logFrames(Thred thread){
        while(!thread.isStackEmpty()){
            Fram frame=thread.popFram();
            Method method=frame.getMethod();
            String className=method.getKlass().getName();
            System.out.println(">> pc:"+frame.getNextPC()+className+"."+method.getName()+" "+method.getDescriptor());
        }
    }

    public static void logInstruction(Fram frame,Instruction inst){
        Method method=frame.getMethod();
        String className=method.getKlass().getName();
        String methodName=method.getName();
        int pc=frame.getThread().getPc();
        System.out.println(className+"."+methodName+"() #"+pc+"    "+inst.getClass());
    }
}
