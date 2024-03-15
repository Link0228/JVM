package ch3;
import ch3.classfile.MemberInfo;
import ch3.classpath.Classpath;
import ch3.classfile.ClassFile;


/**
 * @date 2024.3.6-3.11
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
        String className=cmd.getClassName().replace('.','/');
        ClassFile cf=loadClass(className,cp);
        System.out.println("class:"+cmd.getClassName());
        printClassInfo(cf);
    }

    public static ClassFile loadClass(String className,Classpath cp){
        byte[] classData=cp.readClass(className);
        if(classData.length==0){
            System.out.println("class reading error!");
            throw new RuntimeException();
        }
        ClassFile cf=new ClassFile();
        try{
            cf.parse(classData);
        }catch (RuntimeException e){
            System.out.println("class reading error!");
        }
        return cf;
    }

    public static void printClassInfo(ClassFile cf){
        System.out.println("version:"+cf.getMajorVersion()+"."+cf.getMinorVersion());
        System.out.println("constants count:"+cf.getConstantPool().getLength());
        System.out.println("access flags:"+cf.getAccessFlags());
        System.out.println("this class:"+cf.getClassName());
        System.out.println("super class:"+cf.getSuperClassName());
        System.out.println("interfaces:");
        for(String s: cf.getInterfaceName()){
            System.out.println(s);
        }
        System.out.println("fields count:"+cf.getFields().length);
        for(MemberInfo m:cf.getFields()){
            System.out.println(m.getName());
        }
        System.out.println("methods count:"+cf.getMethods().length);
        for(MemberInfo m:cf.getMethods()){
            System.out.println(m.getName());
        }
    }
}
