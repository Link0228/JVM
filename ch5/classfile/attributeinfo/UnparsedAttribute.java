package ch5.classfile.attributeinfo;

import ch5.classfile.ClassReader;

public class UnparsedAttribute extends AttributeInfo{
    private String name;
    private int length;
    private byte[] info;

    public String getName() {
        return name;
    }

    public long getLength() {
        return length;
    }

    public byte[] getInfo() {
        return info;
    }

    public UnparsedAttribute(String name, int length) {
        this.name = name;
        this.length = length;
    }

    /**
     * @param reader
     */
    @Override
    void readInfo(ClassReader reader) {
        info=reader.readBytes(length);
    }
}
