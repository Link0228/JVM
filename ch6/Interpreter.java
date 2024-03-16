package ch6;

import ch6.instructions.base.BytecodeReader;
import ch6.instructions.base.Instruction;
import ch6.rtda.Fram;
import ch6.rtda.Thred;
import ch6.classfile.MemberInfo;
import ch6.classfile.attributeinfo.CodeAttribute;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/14/15:04
 * @Description:
 */
public class Interpreter {
    public static void interpret(MemberInfo methodInfo){
        CodeAttribute codeAttr=methodInfo.getCodeAttribute();
        int maxLocals= codeAttr.getMaxLocals();
        int maxStack=codeAttr.getMaxStack();
        byte[] bytecode=codeAttr.getCode();
        Thred thread=new Thred();
        Fram frame=thread.newFrame(maxLocals,maxStack);
        thread.pushFram(frame);
        try {
            loop(thread,bytecode);
        } catch (Exception e) {
            System.out.println("LocalVars:"+frame.getLocalVars().localVars[1].getNum());
            System.out.println("OperandStack:"+frame.getOperandStack().toString());
        }
        /*
        thread.PushFrame(frame)
        defer catchErr(frame)
        loop(thread, bytecode)
         */
    }

    public static void loop(Thred thread,byte[] bytecode){
        Fram frame=thread.popFram();
        BytecodeReader reader=new BytecodeReader();
        while(true){
            int pc=frame.getNextPC();
            thread.setPc(pc);
            //decode
            reader.reset(bytecode,pc);
            int opcode= reader.readUint8();
            Instruction inst=Instruction.newInstruction(opcode);
            inst.fetchOperands(reader);
            frame.setNextPC(reader.getPc());
            //execute
            System.out.println("pc:"+pc+" "+inst.getClass());
            inst.execute(frame);
        }
    }
}
