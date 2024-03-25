package ch8.instructions.base;

public class BytecodeReader {
    private byte[] code;
    private int pc;

    public int getPc() {
        return pc;
    }

    public void reset(byte[] code, int pc){
        this.code=code;
        this.pc=pc;
    }

    public int readUint8(){
        byte b=code[pc];
        pc++;
        //读取无符号一字节需要转换成int
        return Byte.toUnsignedInt(b);
    }

    /**
     * 调用ReadUint8（）,有符号一字节即byte
     * @return
     */
    public byte readInt8(){
        return (byte)readUint8();
    }

    public int readUint16(){
        int byte1=readUint8();
        int byte2=readUint8();
        return (byte1<<8)|byte2;
    }

    /**
     * 调用ReadUint16（）,有符号二字节即short
     * @return
     */
    public short readInt16(){
        return (short)readUint16();
    }

    /**
     * 连续读取4字节,有符号四字节即int
     * @return
     */
    public int readInt32(){
        int byte1 = readUint8();
        int byte2 = readUint8();
        int byte3 = readUint8();
        int byte4 = readUint8();
        return (byte1 << 24) | (byte2 << 16) | (byte3 << 8) | byte4;
    }

    public void skipPadding(){
        while(this.pc%4!=0){
            readUint8();
        }
    }

    public int[] readInt32s(int n){
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=readInt32();
        }
        return nums;
    }
}
