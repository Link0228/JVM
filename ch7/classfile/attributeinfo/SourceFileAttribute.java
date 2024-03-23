package ch7.classfile.attributeinfo;

import ch7.classfile.ClassReader;
import ch7.classfile.ConstantPool;
import ch7.classfile.constantinfo.ConstantInfo;

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
