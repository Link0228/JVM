package ch5.classfile.attributeinfo;

import ch5.classfile.ClassReader;


/**
 * 记录方法抛出的异常表
 */
public class ExceptionsAttribute extends AttributeInfo{
    private int[] exceptionIndexTable;

    public int[] getExceptionIndexTable() {
        return exceptionIndexTable;
    }

    /**
     * @param reader
     */
    @Override
    void readInfo(ClassReader reader) {
        exceptionIndexTable=reader.readUint16s();
    }
}
