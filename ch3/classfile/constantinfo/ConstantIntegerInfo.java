package ch3.classfile.constantinfo;

import ch3.classfile.ClassReader;

public class ConstantIntegerInfo extends ConstantInfo{

    private int val;


    public ConstantIntegerInfo(byte tag) {
        this.tag = tag;
    }

    public int getVal() {
        return val;
    }

    public byte getTag() {
        return tag;
    }

    /**
     * @param reader
     */
    @Override
    void readInfo(ClassReader reader) {

        val=reader.readUint32().getInt();
    }
}
