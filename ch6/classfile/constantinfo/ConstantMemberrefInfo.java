package ch6.classfile.constantinfo;

import ch6.classfile.ClassReader;
import ch6.classfile.ConstantPool;

public class ConstantMemberrefInfo extends ConstantInfo{
    private ConstantPool cp;
    private int classIndex;
    private int nameAndTypeIndex;

    public ConstantMemberrefInfo(ConstantPool cp,byte tag) {
        this.tag=tag;
        this.cp = cp;
    }

    public int getClassIndex() {
        return classIndex;
    }

    public int getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    /**
     * @return
     */
    @Override
    public byte getTag() {
        return tag;
    }

    /**
     * @param reader
     */
    @Override
    void readInfo(ClassReader reader) {
        classIndex=reader.readUint16();
        nameAndTypeIndex=reader.readUint16();
    }

    public String getClassName(){
        return cp.getClassName(classIndex);
    }

    public String[] getNameAndDescriptor(){
        return cp.getNameAndType(nameAndTypeIndex);
    }
}
