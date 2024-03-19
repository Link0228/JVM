package ch6.rtda.heap;

import ch6.classfile.ConstantPool;
import ch6.classfile.constantinfo.ConstantClassInfo;
import ch6.classfile.constantinfo.ConstantDoubleInfo;
import ch6.classfile.constantinfo.ConstantFieldrefInfo;
import ch6.classfile.constantinfo.ConstantFloatInfo;
import ch6.classfile.constantinfo.ConstantInfo;
import ch6.classfile.constantinfo.ConstantIntegerInfo;
import ch6.classfile.constantinfo.ConstantInterfaceMethodrefInfo;
import ch6.classfile.constantinfo.ConstantLongInfo;
import ch6.classfile.constantinfo.ConstantMethodrefInfo;
import ch6.classfile.constantinfo.ConstantStringInfo;

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
            switch (cpInfo.getTag()){
                case ConstantInfo.CONSTANT_Integer->{
                    ConstantIntegerInfo intInfo=(ConstantIntegerInfo)cpInfo;
                    consts[i]=new RTConstant<Integer>(intInfo.getVal());//int32
                }
                case ConstantInfo.CONSTANT_Float->{
                    ConstantFloatInfo floatInfo=(ConstantFloatInfo) cpInfo;
                    consts[i]=new RTConstant<Float>(floatInfo.getVal());//float32
                }
                case ConstantInfo.CONSTANT_Long->{
                    ConstantLongInfo longInfo=(ConstantLongInfo) cpInfo;
                    consts[i]=new RTConstant<Long>(longInfo.getVal());//int64
                    i++;
                }
                case ConstantInfo.CONSTANT_Double->{
                    ConstantDoubleInfo doubleInfo=(ConstantDoubleInfo) cpInfo;
                    consts[i]=new RTConstant<Double>(doubleInfo.getVal());
                    i++;
                }
                case ConstantInfo.CONSTANT_String->{
                    ConstantStringInfo stringInfo=(ConstantStringInfo) cpInfo;
                    consts[i]=new RTConstant<String>(stringInfo.getString());
                }
                case ConstantInfo.CONSTANT_Class->{
                    ConstantClassInfo classInfo=(ConstantClassInfo) cpInfo;
                    consts[i]=new RTConstant<ClassRef>(new ClassRef(this,classInfo));
                }
                case ConstantInfo.CONSTANT_Fieldref->{
                    ConstantFieldrefInfo fieldrefInfo=(ConstantFieldrefInfo) cpInfo;
                    consts[i]=new RTConstant<FieldRef>(new FieldRef(this,fieldrefInfo));
                }
                case ConstantInfo.CONSTANT_Methodref->{
                    ConstantMethodrefInfo methodrefInfo=(ConstantMethodrefInfo) cpInfo;
                    consts[i]=new RTConstant<MethodRef>(new MethodRef(this,methodrefInfo));
                }
                case ConstantInfo.CONSTANT_InterfaceMethodref->{
                    ConstantInterfaceMethodrefInfo interfaceMethodrefInfo=(ConstantInterfaceMethodrefInfo) cpInfo;
                    consts[i]=new RTConstant<InterfaceMethodRef>(new InterfaceMethodRef(this,interfaceMethodrefInfo));
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
