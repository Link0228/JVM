package ch4.classfile.attributeinfo;

import ch4.classfile.ClassReader;
import ch4.classfile.ConstantPool;



/*
attribute_info {
u2 attribute_name_index;
u4 attribute_length;
u1 info[attribute_length];
}
 */
public abstract class AttributeInfo {

    abstract void readInfo(ClassReader reader);

    public static AttributeInfo[] readAttributes(ClassReader reader, ConstantPool cp){
        int attributesCount=reader.readUint16();
        AttributeInfo[] attributes=new AttributeInfo[attributesCount];
        for(int i=0;i<attributesCount;i++){
            attributes[i]=readAttribute(reader,cp);
        }
        return attributes;
    }

    public static AttributeInfo readAttribute(ClassReader reader, ConstantPool cp){
        int attrNameIndex=reader.readUint16();
        String attrName=cp.getUtf8(attrNameIndex);
        int attrLen=reader.readUint32().getInt();
        AttributeInfo attrInfo=newAttributeInfo(attrName,attrLen,cp);
        attrInfo.readInfo(reader);
        return attrInfo;
    }

    /**
     * 创建具体的属性实例
     * @param attrName
     * @param attrLen
     * @param cp
     * @return
     */
    public static AttributeInfo newAttributeInfo(String attrName,int attrLen,ConstantPool cp){
            switch (attrName){
                case "Code"->{return new CodeAttribute(cp);}
                case "ConstantValue"->{return new ConstantValueAttribute();}
                case "Deprecated"->{return new DeprecatedAttribute();}
                case "Exceptions"->{return new ExceptionsAttribute();}
                case "LineNumberTable"-> {return new LineNumberTableAttribute();}
                case "LocalVariableTable"->{return new LocalVariableTableAttribute();}
                case "SourceFile"->{return new SourceFileAttribute(cp);}
                case "Synthetic"->{return new SyntheticAttribute();}
                default->{return new UnparsedAttribute(attrName, attrLen);}
                //default: return &UnparsedAttribute{attrName, attrLen, nil}
            }
    }
}
