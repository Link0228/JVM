package ch20.classfile.attributeinfo;

import ch20.classfile.ClassReader;

public class SyntheticAttribute extends AttributeInfo{
    /**
     * @param reader
     */
    @Override
    void readInfo(ClassReader reader) {
        // read nothing
    }
}
