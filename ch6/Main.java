package ch6;
import ch6.classfile.MemberInfo;
import ch6.classpath.Classpath;
import ch6.classfile.ClassFile;
import ch6.rtda.Fram;
import ch6.rtda.LocalVars;
import ch6.rtda.OperandStack;
import ch6.rtda.Thred;
import ch6.rtda.heap.Klass;
import ch6.rtda.heap.KlassLoader;
import ch6.rtda.heap.Method;

import java.sql.SQLOutput;


/**
 * @date 2024.3.16-3.19
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
        KlassLoader classLoader= new KlassLoader(cp);
        String className=cmd.getClassName().replace('.','/');
        Klass mainClass=classLoader.loadClass(className);
        Method mainMethod=mainClass.getMainMethod();
        if(mainMethod!=null){
            Interpreter.interpret(mainMethod);
        }else{
            System.out.println("Main method not found in class "+cmd.getClassName());
        }
    }
}
