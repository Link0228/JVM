package ch20.classfile.constantinfo;

import ch20.classfile.ClassReader;

public class ConstantDoubleInfo extends ConstantInfo{
    private double val;

    public ConstantDoubleInfo(byte tag) {
        this.tag=tag;
    }

    public byte getTag() {
        return tag;
    }

    public double getVal() {
        return val;
    }

    /**
     * @param reader
     */
    @Override
    void readInfo(ClassReader reader) {
        val=reader.readUint64().getDouble();
    }
}
