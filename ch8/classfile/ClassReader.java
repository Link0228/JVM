package ch8.classfile;


import java.util.Arrays;
import java.nio.ByteBuffer;

/**
 * @date 2024.3.5
 */
public class ClassReader {
    byte[] data;
    private int debugCNT=0;

    public ClassReader(byte[] data){
        this.data=data;
    }
    //u1
    public  byte readUint8(){
        byte val=data[0];
        data= Arrays.copyOfRange(data,1,data.length);
        return val;
    }
    //u2
    public int readUint16(){
        byte[] byteArr=Arrays.copyOfRange(data,0,2);
        data= Arrays.copyOfRange(data,2,data.length);
        // 创建一个ByteBuffer对象并将byte数组包装进去
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArr);
        // 读取前两位byte并转换成short
        return (int)byteBuffer.getShort();
    }

    //u4
    public ByteBuffer readUint32(){
        byte[] byteArr=Arrays.copyOfRange(data,0,4);
        data= Arrays.copyOfRange(data,4,data.length);
        return ByteBuffer.wrap(byteArr);
    }

    public ByteBuffer readUint64(){
        byte[] byteArr=Arrays.copyOfRange(data,0,8);
        data= Arrays.copyOfRange(data,8,data.length);
        return ByteBuffer.wrap(byteArr);
    }

    /**
     * readUint16s（）读取uint16表，表的大小由开头的uint16数据指出
     * @return
     */
    public int[] readUint16s(){
        int n=readUint16();
        int[] s=new int[n];
        for(int i=0;i<n;i++){
            s[i]=readUint16();
        }
        return s;
    }

    /**
     * 用于读取指定数量的字节
     * @param length
     * @return
     */
    public byte[] readBytes(int length){
        byte[] byteArr=Arrays.copyOfRange(data,0,length);
        data= Arrays.copyOfRange(data,length,data.length);
        return byteArr;
    }
}
