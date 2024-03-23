package ch7.classfile.attributeinfo;

import ch7.classfile.ClassReader;

public class SyntheticAttribute extends AttributeInfo{
    /**
     * @param reader
     */
    @Override
    void readInfo(ClassReader reader) {
        // read nothing
    }
}
