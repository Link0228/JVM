package ch8;
import ch8.classfile.MemberInfo;
import ch8.classpath.Classpath;
import ch8.classfile.ClassFile;
import ch8.rtda.Fram;
import ch8.rtda.LocalVars;
import ch8.rtda.OperandStack;
import ch8.rtda.Thred;
import ch8.rtda.heap.Klass;
import ch8.rtda.heap.KlassLoader;
import ch8.rtda.heap.Method;

import java.sql.SQLOutput;


/**
 * @date 2024.3.24-
 */
public class Main {
    public static void main(String[] args) {
        Cmd cmd = new Cmd(args);
        if (cmd.isVersionFlag()) {
            System.out.println("version 0.0.1");
        } else if (cmd.isHelpFlag() || cmd.getClassName() == null) {
            cmd.printUsage();
        } else {
            startJVM(cmd);
        }
    }

    public static void startJVM(Cmd cmd){
        Classpath cp=new Classpath(cmd.getXjreOption(),cmd.getCpOption());
        KlassLoader classLoader= new KlassLoader(cp, cmd.isVerboseClassFlag());
        String className=cmd.getClassName().replace('.','/');
        Klass mainClass=classLoader.loadClass(className);
        Method mainMethod=mainClass.getMainMethod();
        if(mainMethod!=null){
            Interpreter.interpret(mainMethod,cmd.isVerboseInstFlag());
        }else{
            System.out.println("Main method not found in class "+cmd.getClassName());
        }
    }
}
