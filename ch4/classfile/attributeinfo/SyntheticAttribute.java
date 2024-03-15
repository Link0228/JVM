package ch4.classfile.attributeinfo;

import ch4.classfile.ClassReader;

public class SyntheticAttribute extends AttributeInfo{
    /**
     * @param reader
     */
    @Override
    void readInfo(ClassReader reader) {
        // read nothing
    }
}
