package ch20.classfile;

import ch20.classfile.constantinfo.ConstantInfo;
import ch20.classfile.constantinfo.ConstantUtf8Info;
import ch20.classfile.constantinfo.ConstantNameAndTypeInfo;
import ch20.classfile.constantinfo.ConstantClassInfo;

public class ConstantPool {
    private ConstantInfo[] infos;

    private int length;

    public int getLength() {
        return length;
    }

    /**
     * 常量池实际上也是一个表，但是有三点需要特别注意。第一，
     * 表头给出的常量池大小比实际大1。假设表头给出的值是n，那么常
     * 量池的实际大小是n–1。第二，有效的常量池索引是1~n–1。0是无效
     * 索引，表示不指向任何常量。第三，CONSTANT_Long_info和
     * CONSTANT_Double_info各占两个位置。也就是说，如果常量池中
     * 存在这两种常量，实际的常量数量比n–1还要少，而且1~n–1的某些
     * 数也会变成无效索引。
     * @param reader
     * @return
     */
    public ConstantPool (ClassReader reader){
        length=0;
        int cpCount=reader.readUint16();
        infos=new ConstantInfo[cpCount];
        //索引从1开始
        for(int i=1;i<cpCount;i++){
            infos[i]=ConstantInfo.readConstantInfo(reader,this);
            length++;
            switch (infos[i].getTag()){
                case ConstantInfo.CONSTANT_Long,ConstantInfo.CONSTANT_Double->{
                    i++;
                }
            }
        }
    }

    /**
     * 法按索引查找常量
     * @param index
     * @return
     */
    public ConstantInfo getConstantInfo(int index){
        if(index<infos.length&&infos[index]!=null){
            return infos[index];
        }else{
            System.out.println("Invalid constant pool index!");
            System.exit(0);
            return null;
        }
    }

    /**
     * 从常量池查找字段或方法的名字和描
     * 述符
     * @param index
     * @return
     */
    public String[] getNameAndType(int index){
          ConstantNameAndTypeInfo ntInfo =(ConstantNameAndTypeInfo)getConstantInfo(index);//强制转换为(*ConstantNameAndTypeInfo)
          String[] nameAndType=new String[2];
          nameAndType[0]=getUtf8(ntInfo.getNameIndex());
          nameAndType[1]=getUtf8(ntInfo.getDescriptorIndex());
          return nameAndType;
    }

    /**
     * 从常量池查找类名
     * @param index
     * @return
     */
    public String getClassName(int index){
        ConstantClassInfo classInfo = (ConstantClassInfo)getConstantInfo(index);//.(*ConstantClassInfo)
        return getUtf8(classInfo.getNameIndex());
    }

    /**
     * 从常量池查找UTF-8字符串
     * @param index
     * @return
     */
    public String getUtf8(int index){
        try{
            ConstantUtf8Info utf8Info = (ConstantUtf8Info)getConstantInfo(index);
            return utf8Info.getVal();
        }catch (ClassCastException e){
            System.out.println("常量池索引"+index);
            e.getMessage();
            return null;
        }
//        ConstantUtf8Info utf8Info = (ConstantUtf8Info)getConstantInfo(index);
//        return utf8Info.getVal();
    }
}
