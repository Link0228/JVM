package ch3.classfile.attributeinfo;

import ch3.classfile.ClassReader;

public class ConstantValueAttribute extends AttributeInfo{
    private int constantValueIndex;

    public int getConstantValueIndex() {
        return constantValueIndex;
    }

    /**
     * @param reader
     */
    @Override
    void readInfo(ClassReader reader) {
        constantValueIndex=reader.readUint16();
    }
}
