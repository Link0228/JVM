package ch6.rtda.heap;

import ch6.classfile.MemberInfo;
import ch6.classfile.attributeinfo.ConstantValueAttribute;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/16/17:16
 * @Description:
 */
public class Field extends ClassMember{

    private int slotId;
    private int constValueIndex;

    public Field(Klass klass) {
        super(klass);
    }

    public static Field[] newFields(Klass klass, MemberInfo[] cfFields ){
        Field[] fields=new Field[cfFields.length];
        for(int i=0;i< cfFields.length;i++){
            fields[i]=new Field(klass);
            fields[i].copyMemberInfo(cfFields[i]);
            fields[i].copyAttributes(cfFields[i]);
        }
        return fields;
    }

    public void copyAttributes(MemberInfo cfField){
        ConstantValueAttribute valAttr= cfField.getConstantValueAttribute();
        if(valAttr!=null){
            this.constValueIndex=valAttr.getConstantValueIndex();
        }
    }

    public int getSlotId() {
        return slotId;
    }

    public int getConstValueIndex() {
        return constValueIndex;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }


    public boolean isStatic(){
        return (this.accessFlags&AcessFlags.ACC_STATIC)!=0;
    }

    public boolean isFinal(){
        return (this.accessFlags&AcessFlags.ACC_FINAL)!=0;
    }

    public boolean isLongOrDouble(){
        return this.descriptor.equals("J")||this.descriptor.equals("D");
    }
}
