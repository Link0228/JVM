package ch8.classfile.constantinfo;

import ch8.classfile.ClassReader;

public class ConstantUtf8Info extends ConstantInfo{

    private String val;

    public ConstantUtf8Info(byte tag) {
        this.tag=tag;
    }

    public byte getTag() {
        return tag;
    }
    public String getVal() {
        return val;
    }



    /**
     * readInfo（）方法先读取出[]byte，然后调用decodeMUTF8（）函数
     * 把它解码成字符串
     * @param reader
     */
    @Override
    void readInfo(ClassReader reader) {
        int length=reader.readUint16();
        byte[] data=reader.readBytes(length);
        //简写，未实现decodeMUTF8（）函数
        val=new String(data);
    }
}
