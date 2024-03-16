package ch5;
import ch5.classfile.MemberInfo;
import ch5.classpath.Classpath;
import ch5.classfile.ClassFile;
import ch5.rtda.Fram;
import ch5.rtda.LocalVars;
import ch5.rtda.OperandStack;


/**
 * @date 2024.3.12-3.15
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
        MemberInfo mainMethod=getMainMethod(cf);
        if(mainMethod!=null){
            Interpreter.interpret(mainMethod);
        }else{
            System.out.println("Main method not found in class "+cmd.getClassName());
        }
//        printClassInfo(cf);
//        Fram fram=new Fram(100,100);
//        testLocalVars(fram.getLocalVars());
//        testOperandStack(fram.getOperandStack());

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

    //测试局部变量
    public static void testLocalVars(LocalVars vars){
        vars.setInt(0, 100);
        vars.setInt(1, -100);
        vars.setLong(2, 2997924580L);
        vars.setLong(4, -2997924580L);
        vars.setFloat(6, 3.1415926f);
        vars.setDouble(7, 2.71828182845);
        vars.setRef(9, null);
        System.out.println(vars.getInt(0));
        System.out.println(vars.getInt(1));
        System.out.println(vars.getLong(2));
        System.out.println(vars.getLong(4));
        System.out.println(vars.getFloat(6));
        System.out.println(vars.getDouble(7));
        System.out.println(vars.getRef(9));
    }

    //测试操作数栈
    public static void testOperandStack(OperandStack ops) {
        ops.pushInt(100);
        ops.pushInt(-100);
        ops.pushLong(2997924580L);
        ops.pushLong(-2997924580L);
        ops.pushFloat(3.1415926f);
        ops.pushDouble(2.71828182845);
        ops.pushRef(null);
        System.out.println(ops.popRef());
        System.out.println(ops.popDouble());
        System.out.println(ops.popFloat());
        System.out.println(ops.popLong());
        System.out.println(ops.popLong());
        System.out.println(ops.popInt());
        System.out.println(ops.popInt());
    }

    public static MemberInfo getMainMethod(ClassFile cf){
        for(MemberInfo m:cf.getMethods()){
            if(m.getName().equals("main")&&m.getDescriptor().equals("([Ljava/lang/String;)V")){
                return m;
            }
        }
        return null;
    }
}
