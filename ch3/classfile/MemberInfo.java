package ch3.classfile;
import ch3.classfile.attributeinfo.AttributeInfo;

public class MemberInfo {
    private ConstantPool cp;
    private  int accessFlags;
    private int nameIndex;
    private int descriptorIndex;
    private  AttributeInfo[] attributes;


    /**
     * @param reader
     * @param cp
     */
    public MemberInfo(ClassReader reader,ConstantPool cp){
//        return &MemberInfo{
//            cp: cp,
//                    accessFlags: reader.readUint16(),
//                    nameIndex: reader.readUint16(),
//                    descriptorIndex: reader.readUint16(),
//                    attributes: readAttributes(reader, cp), // 见
//                    3.4
//        }

        this.cp=cp;
        accessFlags=reader.readUint16();
        nameIndex=reader.readUint16();
        descriptorIndex=reader.readUint16();
        attributes=AttributeInfo.readAttributes(reader, cp);
    }

    /**
     * 读取字段或方法数据
     * @param reader
     * @param cp
     * @return
     */
    public static MemberInfo[] readMembers(ClassReader reader,ConstantPool cp){
        int memberCount=reader.readUint16();
        MemberInfo[] members=new MemberInfo[memberCount];
        for(int i=0;i<memberCount;i++){
            try{
                members[i]=new MemberInfo(reader,cp);
            }catch (NullPointerException|IllegalArgumentException e){
                System.out.println("No"+i);
            }
        }
        return members;
    }

    public int getAccessFlags() {
        return accessFlags;
    }

    /**
     * 从常量
     * 池查找字段或方法名
     * @return
     */
    public String getName(){
        return cp.getUtf8(nameIndex);
    }

    /**
     * 从常量池查找字段或方法描述符
     * @return
     */
    public String getDescriptor(){
        return cp.getUtf8(descriptorIndex);
    }
}
