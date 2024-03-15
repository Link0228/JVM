package ch20.classfile.constantinfo;

import ch20.classfile.ClassReader;
import ch20.classfile.ConstantPool;

public abstract class ConstantInfo {
    public static final int CONSTANT_Class = 7;
    public static final int CONSTANT_Fieldref = 9;
    public static final int CONSTANT_Methodref = 10;

    public static final int CONSTANT_InterfaceMethodref = 11;

    public static final int CONSTANT_String = 8;

    public static final int CONSTANT_Integer = 3;

    public static final int CONSTANT_Float = 4;

    public static final int CONSTANT_Long = 5;

    public static final int CONSTANT_Double = 6;

    public static final int CONSTANT_NameAndType = 12;

    public static final int CONSTANT_Utf8 = 1;

    public static final int CONSTANT_MethodHandle = 15;

    public static final int CONSTANT_MethodType = 16;

    public static final int CONSTANT_InvokeDynamic = 18;


    protected byte tag;
    /**
     * 先读出tag值，然后调用newConstantInfo（）函数创建具
     * 体的常量，最后调用常量的readInfo（）方法读取常量信息
     * @param reader
     * @param cp
     * @return
     */
    public static ConstantInfo  readConstantInfo(ClassReader reader, ConstantPool cp){
        byte tag=reader.readUint8();
        ConstantInfo c=newConstantInfo(tag,cp);
        c.readInfo(reader);
        return c;
    }

    /**
     * TODO
     * 根据tag值创建具体的常量
     * @param tag
     * @param cp
     * @return
     */
    static ConstantInfo newConstantInfo(byte tag, ConstantPool cp){
        switch (tag){
            case CONSTANT_Integer-> {return new ConstantIntegerInfo(tag);}
            case CONSTANT_Float->{return new ConstantFloatInfo(tag);}
            case CONSTANT_Long->{return new ConstantLongInfo(tag);}
            case CONSTANT_Double->{return new ConstantDoubleInfo(tag);}
            case CONSTANT_Utf8->{return new ConstantUtf8Info(tag);}
            case CONSTANT_String->{return new ConstantStringInfo(cp,tag);}
            case CONSTANT_Class->{return new ConstantClassInfo(cp,tag);}
            case CONSTANT_Fieldref->{return new ConstantFieldrefInfo(cp,tag);}
            case CONSTANT_Methodref->{return new ConstantMethodrefInfo(cp,tag);}
            case CONSTANT_InterfaceMethodref->{return new ConstantInterfaceMethodrefInfo(cp,tag);}
            case CONSTANT_NameAndType->{return new ConstantNameAndTypeInfo(tag);}
//            case CONSTANT_MethodType: return &ConstantMethodTypeInfo{}
//            case CONSTANT_MethodHandle: return &ConstantMethodHandleInfo{}
//            case CONSTANT_InvokeDynamic: return &ConstantInvokeDynamicInfo{}
            default-> {
                System.out.println("java.lang.ClassFormatError: constant pool tag!");
                return null;
            }
        }
    }

    public abstract byte getTag();

    abstract void readInfo(ClassReader reader);
}
