package ch2;
import ch2.classpath.Classpath;
import java.io.IOException;


/**
 * @date 2024.2.27-3.5
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
        System.out.println("classpath:"+cp.fileToString());
        System.out.println("class:"+cmd.getClassName());
        for(int i=0;i<cmd.getArgs().length;i++) {
            System.out.println("args" + (i + 1) +":  "+ cmd.getArgs()[i]);
        }
        String className=cmd.getClassName().replace('.','/');
        try{
            byte[] result=cp.readClass(className);
            System.out.println("class data:");
            for(byte rs:result){
                System.out.println(rs);
            }
        }catch (RuntimeException r){
            System.out.println("Could not find or load main class");
        }
    }
}
