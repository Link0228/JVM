package ch20.classfile;
import java.io.IOException;
import ch20.classfile.attributeinfo.AttributeInfo;

public class ClassFile {
    private int magic;//魔数
    //magic uint32
    private int minorVersion;
    private int majorVersion;
    private ConstantPool constantPool;
    private int accessFlags;
    private int thisClass;
    private int superClass;
    private int[] interfaces;

    private MemberInfo[] fields;

    private MemberInfo[] methods;


    private AttributeInfo[] attributes;

    public void parse(byte[] classData){
        try {
            ClassReader cr = new ClassReader(classData);
            read(cr);
        }catch (RuntimeException r){
            System.out.println("parse wrong!");
            r.printStackTrace();
        }
    }

    /**
     * read（）
     * 方法依次调用其他方法解析class文件
     * @param reader
     */
    public void read(ClassReader reader){
          readAndCheckMagic(reader);
          readAndCheckVersion(reader);
          constantPool= new ConstantPool(reader);
          accessFlags = reader.readUint16();
          thisClass = reader.readUint16();
          superClass = reader.readUint16();
          interfaces = reader.readUint16s();
          fields = MemberInfo.readMembers(reader, constantPool);
          methods = MemberInfo.readMembers(reader, constantPool);
          attributes = AttributeInfo.readAttributes(reader, constantPool);
    }


    /**
     * class文件的魔数
     * 是“0xCAFEBABE”。
     * @param reader
     */
    public void readAndCheckMagic(ClassReader reader) {
        int magic=reader.readUint32().getInt();
        if(magic!=0xCAFEBABE){
            System.out.println("java.lang.ClassFormatError: magic!");
            System.exit(0);
        }
    }

    /**
     * 参考
     * Java 8，支持版本号为45.0~52.0的class文件。如果遇到其他版本号，
     * 暂时先调用panic（）方法终止程序执行。
     * @param reader
     */
    public void readAndCheckVersion(ClassReader reader) {
        minorVersion=reader.readUint16();
        majorVersion= reader.readUint16();
        switch (majorVersion){
            case 45 -> {
                return;
            }
            case 46,47,48,49,50,51,52-> {
                if(minorVersion==0)
                    return;
            }
        }
        System.out.println("java.lang.UnsupportedClassVersionError!");
        System.exit(0);
    }

    public int getMinorVersion() {
        return minorVersion;
    }

    public int getMajorVersion() {
        return majorVersion;
    }

    public int getAccessFlags() {
        return accessFlags;
    }

    public int getThisClass() {
        return thisClass;
    }

    public ConstantPool getConstantPool() {
        return constantPool;
    }

    /**
     * 从常量池查找类名
     * @return
     */
    public String getClassName(){
        return constantPool.getClassName(thisClass);
    }

    /**
     * 从常量池查找超类名
     * @return
     */
    public String getSuperClassName(){
        if (superClass > 0) {
            return constantPool.getClassName(superClass);
        }
        return "";// 只有 java.lang.Object没有超类
    }

    /**
     * 从常量池查找接口名
     * @return
     */
    public String[] getInterfaceName(){
        String[] interfaceNames =new String[interfaces.length];
        for(int i=0;i<interfaces.length;i++){
            interfaceNames[i]=constantPool.getClassName(interfaces[i]);
        }
        return interfaceNames;
    }

    public MemberInfo[] getFields() {
        return fields;
    }

    public MemberInfo[] getMethods() {
        return methods;
    }
}
