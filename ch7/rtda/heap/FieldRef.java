package ch7.rtda.heap;

import ch7.classfile.constantinfo.ConstantFieldrefInfo;
import ch7.classfile.constantinfo.ConstantMemberrefInfo;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/17/12:04
 * @Description:
 */
public class FieldRef extends MemberRef{
    private Field field;

    public FieldRef(RTConstantPool cp, ConstantFieldrefInfo refInfo) {
        this.cp=cp;
        this.copyMemberRefInfo((ConstantMemberrefInfo) refInfo);
    }

    public Field resolvedField(){
        if(this.field==null){
            this.resolveFieldRef();
        }
        return this.field;
    }

    public void resolveFieldRef(){
        Klass d=this.cp.getKlass();
        Klass c=this.resolvedClass();
        Field field=lookupField(c,this.name,this.descriptor);
        if(field==null){
            System.out.println("java.lang.NoSuchFieldError");
            System.exit(0);
        }
        if(!field.isAccessibleTo(d)){
            System.out.println("java.lang.NoSuchFieldError");
            System.exit(0);
        }
        this.field=field;
    }

    /**
     * 首先在C的字段中查找。如果找不到，在C的直接接口递归应
     * 用这个查找过程。如果还找不到的话，在C的超类中递归应用这个
     * 查找过程。如果仍然找不到，则查找失败。
     * @param c
     * @param descriptor
     * @param name
     * @return
     */
    Field lookupField(Klass c,String name,String  descriptor ){
        for(Field field: c.getFields()){
            if(field.name.equals(name)&&field.descriptor.equals(descriptor)){
                return field;
            }
        }
        for(Klass iface:c.getInterfaces()){
            Field field=lookupField(iface,name,descriptor);
            if(field!=null){
                return field;
            }
        }
        if(c.getSuperClass()!=null){
            return lookupField(c.getSuperClass(),name,descriptor);
        }
        return null;
    }
}
