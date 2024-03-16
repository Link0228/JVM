package ch6.classfile.constantinfo;

import ch6.classfile.ClassReader;

public class ConstantFloatInfo extends ConstantInfo{

    private float val;


    public ConstantFloatInfo(byte tag) {
        this.tag = tag;
    }



    public float getVal() {
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
        val=reader.readUint32().getFloat();
    }

}
