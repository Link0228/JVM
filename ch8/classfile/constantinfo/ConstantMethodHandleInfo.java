package ch8.classfile.constantinfo;

import ch8.classfile.ClassReader;

public class ConstantMethodHandleInfo extends ConstantInfo{

    private int referenceKind;
    private int referenceIndex;


    public ConstantMethodHandleInfo(byte tag) {
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
        this.referenceKind=reader.readUint8();
        this.referenceIndex=reader.readUint16();
    }
}
