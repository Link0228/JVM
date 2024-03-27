package ch8.rtda.heap;

import ch8.classfile.ClassFile;
import ch8.classpath.Classpath;
import ch8.classpath.Entry;
import ch8.rtda.LocalVars;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/17/14:54
 * @Description:
 */
public class KlassLoader {
    private Classpath cp;
    private HashMap<String,Klass> classMap;//loaded classes

    private boolean verboseFlag;

    public KlassLoader(Classpath cp,boolean verboseFlag) {
        this.cp = cp;
        this.classMap=new HashMap<String,Klass>();
        this.verboseFlag=verboseFlag;
    }

    public Klass loadClass(String name){
        if(classMap.containsKey(name)){
            return classMap.get(name);
        }else if(name.charAt(0)=='['){
            return loadArrayClass(name);
        }else{
            return loadNonArrayClass(name);
        }
    }

    public Klass loadArrayClass(String name){
        Klass klass=new Klass(
                AcessFlags.ACC_PUBLIC,
                name,
                this,
                true,
                this.loadClass("java/lang/Object"),
                new Klass[]{
                        this.loadClass("java/lang/Cloneable"),
                        this.loadClass("java/io/Serializable")
                }
        );
        classMap.put(name,klass);
        return klass;
    }

    public Klass loadNonArrayClass(String name){
        byte[] data=readClass(name);
        Entry entry=getEntry(this.cp);
        Klass klass=defineClass(data);
        link(klass);
        if(verboseFlag){
            System.out.println("[Loaded "+name+" from "+entry.fileToString());
        }
        return klass;
    }

    /**
     * readClass（）方法只是调用了Classpath的ReadClass（）方法，并进
     * 行了错误处理
     * @param name
     * @return
     */
    public byte[] readClass(String name){
        try {
            return cp.readClass(name);
        } catch (Exception e) {
            throw new RuntimeException("java.lang.ClassNotFoundException: "+name);
        }
    }

    public Entry getEntry(Classpath cp){
        return cp.getEntry();
    }

    /**
     * defineClass（）方法首先调用parseClass（）函数把class文件数据
     * 转换成Class结构体。Class结构体的superClass和interfaces字段存放
     * 超类名和直接接口表，这些类名其实都是符号引用。
     * @param data
     * @return
     */
    public Klass defineClass(byte[] data){
        Klass klass=parseClass(data);
        klass.setLoader(this);
        resolveSuperClass(klass);
        resolveInterfaces(klass);
        classMap.put(klass.getName(),klass);
        return klass;
    }
    public Klass parseClass(byte[] data){
        try {
            ClassFile cf=new ClassFile();
            cf.parse(data);
            return new Klass(cf);
        } catch (Exception e) {
            throw new RuntimeException("java.lang.ClassFormatError");
        }
    }

    /**
     * 除java.lang.Object以外，所有的类都有且仅有一个
     * 超类。因此，除非是Object类，否则需要递归调用LoadClass（）方法
     * 加载它的超类。
     * @param klass
     */
    public void resolveSuperClass(Klass klass){
        if(!klass.getName().equals("java/lang/Object")){
            klass.setSuperClass(klass.getLoader().loadClass(klass.getSuperClassName()));
        }
    }

    public void resolveInterfaces(Klass klass){
        int interfaceCount=klass.getInterfaceNames().length;
        if(interfaceCount>0){
            klass.setInterfaces(new Klass[interfaceCount]);
            for(int i=0;i<interfaceCount;i++){
                //class.interfaces[i] = class.loader.LoadClass(interfaceName)
                klass.getInterfaces()[i]=klass.getLoader().loadClass(klass.getInterfaceNames()[i]);
            }
        }
    }

    /**
     * 类的链接分为验证和准备两个必要阶段
     */
    public void link(Klass klass){
        verify(klass);
        prepare(klass);
    }

    /**
     * Java虚拟机规范4.10节详细介绍了类的验证算法
     * @param klass
     */
    public void verify(Klass klass){
        // todo
    }

    public void prepare(Klass klass){
        calcInstanceFieldSlotIds(klass);
        calcStaticFieldSlotIds(klass);
        allocAndInitStaticVars(klass);

    }

    /**
     * 计算实例字段的个数，同时给它们编号
     * @param klass
     */
    public void calcInstanceFieldSlotIds(Klass klass){
        int slotId=0;
        if(klass.getSuperClass()!=null){
            slotId=klass.getSuperClass().getInstanceSlotCount();
        }
        for(Field field:klass.getFields()){
            if(!field.isStatic()){
                field.setSlotId(slotId);
                slotId++;
                if(field.isLongOrDouble()){
                    slotId++;
                }
            }
        }
        klass.setInstanceSlotCount(slotId);
    }

    /**
     * 计算静态字段的个数，同时给它们编号
     */
    public void calcStaticFieldSlotIds(Klass klass){
        int slotId=0;
        for(Field field:klass.getFields()){
            if(field.isStatic()){
                field.setSlotId(slotId);
                slotId++;
                if(field.isLongOrDouble()){
                    slotId++;
                }
            }
        }
        klass.setStaticSlotCount(slotId);
    }

    public void allocAndInitStaticVars(Klass klass){
        klass.setStaticVars(new LocalVars(klass.getStaticSlotCount()));
        for(Field field:klass.getFields()){
            if(field.isStatic()&&field.isFinal()){
                initStaticFinalVar(klass, field);
            }
        }
    }

    /**
     * 从常量池中加载常量值，然后给静态变量赋值
     * @param klass
     * @param field
     */
    public void initStaticFinalVar(Klass klass,Field field){
        LocalVars vars=klass.getStaticVars();
        RTConstantPool rtcp=klass.getConstantPool();
        int cpIndex=field.getConstValueIndex();
        int slotId= field.getSlotId();
        if(cpIndex>0){
         switch (field.descriptor) {
             case "Z", "B", "C", "S", "I"->{
                 int val=(int)rtcp.getConstant(cpIndex).getT();
                 vars.setInt(slotId,val);
             }
             case "J"->{
                 long val=(long)rtcp.getConstant(cpIndex).getT();
                 vars.setLong(slotId,val);
             }
             case "F"->{
                 float val=(float)rtcp.getConstant(cpIndex).getT();
                 vars.setFloat(slotId,val);
             }
             case "D"->{
                 double val=(double)rtcp.getConstant(cpIndex).getT();
                 vars.setDouble(slotId,val);
             }
             case "Ljava/lang/String;"->{
                 String jaStr=(String) rtcp.getConstant(cpIndex).getT();
                 Objext jStr=new StringPool().jString(klass.getLoader(), jaStr);
                 vars.setRef(slotId,jStr);
             }
         }
        }
    }
}
