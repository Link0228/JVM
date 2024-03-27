package ch8.classfile.constantinfo;

import ch8.classfile.ClassReader;

public class ConstantInvokeDynamicInfo extends ConstantInfo{
    private int bootstrapMethodAttrIndex;
    private int nameAndTypeIndex;

    public ConstantInvokeDynamicInfo(byte tag) {
        this.tag=tag;
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
        this.bootstrapMethodAttrIndex=reader.readUint16();
        this.nameAndTypeIndex=reader.readUint16();
    }
}
