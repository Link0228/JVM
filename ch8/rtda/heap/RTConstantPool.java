package ch8.rtda.heap;

import ch8.classfile.ConstantPool;
import ch8.classfile.constantinfo.ConstantClassInfo;
import ch8.classfile.constantinfo.ConstantDoubleInfo;
import ch8.classfile.constantinfo.ConstantFieldrefInfo;
import ch8.classfile.constantinfo.ConstantFloatInfo;
import ch8.classfile.constantinfo.ConstantInfo;
import ch8.classfile.constantinfo.ConstantIntegerInfo;
import ch8.classfile.constantinfo.ConstantInterfaceMethodrefInfo;
import ch8.classfile.constantinfo.ConstantLongInfo;
import ch8.classfile.constantinfo.ConstantMethodrefInfo;
import ch8.classfile.constantinfo.ConstantStringInfo;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/16/18:21
 * @Description:
 */
public class RTConstantPool {
    private Klass klass;
    RTConstant[] consts;

    public RTConstantPool(Klass klass, ConstantPool cfCp) {
        int cpCount= cfCp.getInfoLength();
        this.consts=new RTConstant[cpCount];
        this.klass = klass;
        for(int i=1;i<cpCount;i++){
            ConstantInfo cpInfo=cfCp.getConstantInfo(i);
            int tag=cpInfo.getTag();
            switch (tag){
                case ConstantInfo.CONSTANT_Integer->{
                    ConstantIntegerInfo intInfo=(ConstantIntegerInfo)cpInfo;
                    consts[i]=new RTConstant<Integer>(intInfo.getVal(),tag);//int32
                }
                case ConstantInfo.CONSTANT_Float->{
                    ConstantFloatInfo floatInfo=(ConstantFloatInfo) cpInfo;
                    consts[i]=new RTConstant<Float>(floatInfo.getVal(),tag);//float32
                }
                case ConstantInfo.CONSTANT_Long->{
                    ConstantLongInfo longInfo=(ConstantLongInfo) cpInfo;
                    consts[i]=new RTConstant<Long>(longInfo.getVal(),tag);//int64
                    i++;
                }
                case ConstantInfo.CONSTANT_Double->{
                    ConstantDoubleInfo doubleInfo=(ConstantDoubleInfo) cpInfo;
                    consts[i]=new RTConstant<Double>(doubleInfo.getVal(),tag);
                    i++;
                }
                case ConstantInfo.CONSTANT_String->{
                    ConstantStringInfo stringInfo=(ConstantStringInfo) cpInfo;
                    consts[i]=new RTConstant<String>(stringInfo.getString(),tag);
                }
                case ConstantInfo.CONSTANT_Class->{
                    ConstantClassInfo classInfo=(ConstantClassInfo) cpInfo;
                    consts[i]=new RTConstant<ClassRef>(new ClassRef(this,classInfo),tag);
                }
                case ConstantInfo.CONSTANT_Fieldref->{
                    ConstantFieldrefInfo fieldrefInfo=(ConstantFieldrefInfo) cpInfo;
                    consts[i]=new RTConstant<FieldRef>(new FieldRef(this,fieldrefInfo),tag);
                }
                case ConstantInfo.CONSTANT_Methodref->{
                    ConstantMethodrefInfo methodrefInfo=(ConstantMethodrefInfo) cpInfo;
                    consts[i]=new RTConstant<MethodRef>(new MethodRef(this,methodrefInfo),tag);
                }
                case ConstantInfo.CONSTANT_InterfaceMethodref->{
                    ConstantInterfaceMethodrefInfo interfaceMethodrefInfo=(ConstantInterfaceMethodrefInfo) cpInfo;
                    consts[i]=new RTConstant<InterfaceMethodRef>(new InterfaceMethodRef(this,interfaceMethodrefInfo),tag);
                }
            }
        }
    }

    public RTConstant getConstant(int index){
        RTConstant c=consts[index];
        if(c!=null){
            return c;
        }
        else{
            throw new RuntimeException("No constants at index "+index);
        }
    }

    public Klass getKlass() {
        return klass;
    }
}
