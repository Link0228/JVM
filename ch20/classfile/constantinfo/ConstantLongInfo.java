package ch20.classfile.constantinfo;

import ch20.classfile.ClassReader;

public class ConstantLongInfo extends ConstantInfo{
    private long val;

    public ConstantLongInfo(byte tag) {
        this.tag=tag;
    }

    public byte getTag() {
        return tag;
    }

    public long getVal() {
        return val;
    }

    /**
     * @param reader
     */
    @Override
    void readInfo(ClassReader reader) {
        val=reader.readUint64().getLong();
    }
}
