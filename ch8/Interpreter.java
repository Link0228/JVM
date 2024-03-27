package ch8;

import ch8.instructions.base.BytecodeReader;
import ch8.instructions.base.Instruction;
import ch8.rtda.Fram;
import ch8.rtda.Thred;
import ch8.classfile.MemberInfo;
import ch8.classfile.attributeinfo.CodeAttribute;
import ch8.rtda.heap.*;

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
    public static void interpret(Method method,boolean logInst,String[] args){
        Thred thread=new Thred();
        Fram frame=thread.newFrame(method);
        thread.pushFram(frame);
        Objext jArgs=createArgsArray(method.getKlass().getLoader(), args);
        frame.getLocalVars().setRef(0,jArgs);
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
            System.out.println(">> pc:"+frame.getNextPC()+"  "+className+"."+method.getName()+" "+method.getDescriptor());
        }
    }

    public static void logInstruction(Fram frame,Instruction inst){
        Method method=frame.getMethod();
        String className=method.getKlass().getName();
        String methodName=method.getName();
        int pc=frame.getThread().getPc();
        System.out.println(className+"."+methodName+"() #"+pc+"    "+inst.getClass());
    }

    private static Objext createArgsArray(KlassLoader loader,String[] args){
        Klass stringClass=loader.loadClass("java/lang/String");
        Objext argsArr=stringClass.getArrayClass().newArray(args.length);
        Objext[] jArgs=argsArr.getRefs();
        for (int i = 0; i < args.length; i++) {
            jArgs[i]=new StringPool().jString(loader,args[i]);
        }
        return argsArr;
    }
}
