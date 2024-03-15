package ch5;

import ch5.instructions.base.BytecodeReader;
import ch5.rtda.Fram;
import ch5.rtda.Thred;
import ch5.classfile.MemberInfo;
import ch5.classfile.attributeinfo.CodeAttribute;

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
        }
    }
}