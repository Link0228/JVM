package ch5.classfile.attributeinfo;

import ch5.classfile.ClassReader;

/**
 * 存放方法的局部变量信息
 */
public class LocalVariableTableAttribute extends AttributeInfo{
    private LocalVariableTableEntry[] localVariableTable;

    @Override
    void readInfo(ClassReader reader) {
        int localVariableTableLength=reader.readUint16();
        localVariableTable=new LocalVariableTableEntry[localVariableTableLength];
        for(int i=0;i<localVariableTableLength;i++){
            localVariableTable[i]=new LocalVariableTableEntry(
                    reader.readUint16(),
                    reader.readUint16(),
                    reader.readUint16(),
                    reader.readUint16(),
                    reader.readUint16()
            );
        }

    }

    public static class LocalVariableTableEntry{
        private int startPc;
        private int length;

        private int nameIndex;

        private int descriptorIndex;

        private int index;

        public LocalVariableTableEntry(int startPc, int length, int nameIndex, int descriptorIndex, int index) {
            this.startPc = startPc;
            this.length = length;
            this.nameIndex = nameIndex;
            this.descriptorIndex = descriptorIndex;
            this.index = index;
        }

        public int getStartPc() {
            return startPc;
        }

        public int getLength() {
            return length;
        }

        public int getNameIndex() {
            return nameIndex;
        }

        public int getDescriptorIndex() {
            return descriptorIndex;
        }

        public int getIndex() {
            return index;
        }
    }
}
