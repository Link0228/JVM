package ch8.classfile.constantinfo;

import ch8.classfile.ClassReader;

public class ConstantMethodTypeInfo extends ConstantInfo{

    private int descriptorIndex;

    public ConstantMethodTypeInfo(byte tag) {
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
    this.descriptorIndex=reader.readUint16();
    }
}
