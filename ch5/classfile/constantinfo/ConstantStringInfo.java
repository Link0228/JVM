package ch5.classfile.constantinfo;

import ch5.classfile.ClassReader;
import ch5.classfile.ConstantPool;

public class ConstantStringInfo extends ConstantInfo{
    private int stringIndex;
    private ConstantPool cp;


    public ConstantStringInfo(ConstantPool cp,byte tag) {
        this.tag=tag;
        this.cp = cp;
    }


    public byte getTag() {
        return tag;
    }
    public int getStringIndex() {
        return stringIndex;
    }

    /**
     * @param reader
     */
    @Override
    void readInfo(ClassReader reader) {
        stringIndex=reader.readUint16();
    }

    public String getString(){
        return cp.getUtf8(stringIndex);
    }
}
