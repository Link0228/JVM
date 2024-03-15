package ch3.classfile.constantinfo;

import ch3.classfile.ClassReader;
import ch3.classfile.ConstantPool;

public class ConstantClassInfo extends ConstantInfo{

    private ConstantPool cp;
    private int nameIndex;
    public ConstantClassInfo(ConstantPool cp, byte tag ) {
        this.tag=tag;
        this.cp=cp;
    }

    public int getNameIndex() {
        return nameIndex;
    }

    /**
     * @return
     */
    @Override
    public byte getTag() {
        return tag;
    }

    /**
     * @param reader
     */
    @Override
    void readInfo(ClassReader reader) {
        nameIndex=reader.readUint16();
    }


    public String gertName(){
        return cp.getUtf8(nameIndex);
    }
}
