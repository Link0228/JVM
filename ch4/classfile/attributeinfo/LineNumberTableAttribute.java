package ch4.classfile.attributeinfo;


import ch4.classfile.ClassReader;

/**
 * 存放方法的行号信息
 */
public class LineNumberTableAttribute extends AttributeInfo{

    private LineNumberTableEntry[] lineNumberTable;
    /**
     * @param reader
     */
    @Override
    void readInfo(ClassReader reader) {
        int lineNumberTableLength=reader.readUint16();
        lineNumberTable=new LineNumberTableEntry[lineNumberTableLength];
        for(int i=0;i<lineNumberTableLength;i++){
            lineNumberTable[i]=new LineNumberTableEntry(
                    reader.readUint16(),
                    reader.readUint16()
            );
        }
    }

    public static class LineNumberTableEntry{
        private int startPc;
        private int lineNumber;

        public LineNumberTableEntry(int startPc, int lineNumber) {
            this.startPc = startPc;
            this.lineNumber = lineNumber;
        }

        public int getStartPc() {
            return startPc;
        }

        public int getLineNumber() {
            return lineNumber;
        }
    }
}
