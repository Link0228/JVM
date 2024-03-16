package ch6.rtda.heap;

import ch6.classfile.ClassFile;
import ch6.classfile.ConstantPool;
import ch6.rtda.Slote;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/15/21:24
 * @Description:
 */
public class Klass {
    private int accessFlags;
    private String name;

    private String superClassName;

    private String[] interfaceNames;

    private ConstantPool constantPool;

    //TODO
    //    fields []*Field
    //    methods []*Method
    //    loader *ClassLoader
    private Klass superClass;

    private Klass[] interfaces;

    private  int instanceSlotCount;

    private int staticSlotCount;

    private Slote staticVars;

    public Klass(ClassFile cf){
        this.accessFlags=cf.getAccessFlags();
        this.name=cf.getClassName();
        this.superClassName=cf.getSuperClassName();
        this.interfaceNames=cf.getInterfaceName();
        /*
        TODO
        class.constantPool = newConstantPool(class, cf.ConstantPool()) // 见
        6.2小节
        class.fields = newFields(class, cf.Fields()) // 见
        6.1.2小节
        class.methods = newMethods(class, cf.Methods()) // 见
        6.1.3小节
         */
    }
    public boolean isPublic(){
        return (accessFlags&AcessFlags.ACC_PUBLIC)!=0;
    }
    //TODO 7more
}
