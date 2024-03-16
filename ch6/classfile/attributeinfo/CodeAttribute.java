package ch6.classfile.attributeinfo;

import ch6.classfile.ClassReader;
import ch6.classfile.ConstantPool;


/**
 * 存 放字节码等方法相关信息
 */
public class CodeAttribute extends AttributeInfo{
    private ConstantPool cp;
    private int maxStack;
    private int maxLocals;
    private byte[] code;
    private ExceptionTableEntry[] exceptionTable;
    private AttributeInfo[] attributes;

    public CodeAttribute(ConstantPool cp) {
        this.cp = cp;
    }

    public int getMaxStack() {
        return maxStack;
    }

    public int getMaxLocals() {
        return maxLocals;
    }

    public byte[] getCode() {
        return code;
    }

    /**
     * @param reader
     */
    @Override
    void readInfo(ClassReader reader) {
        maxStack=reader.readUint16();
        maxLocals=reader.readUint16();
        int codeLength=reader.readUint32().getInt();
        code=reader.readBytes(codeLength);
        exceptionTable = readExceptionTable(reader);
        attributes=readAttributes(reader,cp);
    }

    public ExceptionTableEntry[] readExceptionTable(ClassReader reader){
        int exceptionTableLength=reader.readUint16();
        exceptionTable= new ExceptionTableEntry[exceptionTableLength];
        for(int i=0;i<exceptionTableLength;i++){
            exceptionTable[i]=new ExceptionTableEntry(reader.readUint16(),
                                                      reader.readUint16(),
                                                      reader.readUint16(),
                                                      reader.readUint16());
        }
        return exceptionTable;
    }

    public static class ExceptionTableEntry{
        private int startPc;
        private int   endPc;
        private int  handlerPc;
        private int  catchType;

        public ExceptionTableEntry(int startPc, int endPc, int handlerPc, int catchType) {
            this.startPc = startPc;
            this.endPc = endPc;
            this.handlerPc = handlerPc;
            this.catchType = catchType;
        }

        public int getStartPc() {
            return startPc;
        }

        public int getEndPc() {
            return endPc;
        }

        public int getHandlerPc() {
            return handlerPc;
        }

        public int getCatchType() {
            return catchType;
        }
    }
}
