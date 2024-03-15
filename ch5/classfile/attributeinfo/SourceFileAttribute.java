package ch5.classfile.attributeinfo;

import ch5.classfile.ClassReader;
import ch5.classfile.ConstantPool;
import ch5.classfile.constantinfo.ConstantInfo;

public class SourceFileAttribute extends AttributeInfo{
    private ConstantPool cp;
    private int sourceFileIndex;

    public int getSourceFileIndex() {
        return sourceFileIndex;
    }

    public SourceFileAttribute(ConstantPool cp) {
        this.cp = cp;
    }

    /**
     * @param reader
     */
    @Override
    void readInfo(ClassReader reader) {
        sourceFileIndex=reader.readUint16();
    }
    public String getFileName(){
        return cp.getUtf8(sourceFileIndex);
    }
}
