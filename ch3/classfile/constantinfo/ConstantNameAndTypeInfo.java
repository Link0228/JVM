package ch3.classfile.constantinfo;

import ch3.classfile.ClassReader;

public class ConstantNameAndTypeInfo extends ConstantInfo{
    private int nameIndex;

    private int descriptorIndex;

    public ConstantNameAndTypeInfo(byte tag) {
        this.tag=tag;
    }

    public int getNameIndex() {
        return nameIndex;
    }

    public int getDescriptorIndex() {
        return descriptorIndex;
    }

    /**
     * @return
     */
    @Override
    public byte getTag() {
        return this.tag;
    }

    /**
     * @param reader
     */
    @Override
    void readInfo(ClassReader reader) {
        nameIndex=reader.readUint16();
        descriptorIndex=reader.readUint16();
    }
}
