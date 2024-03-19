package ch6.rtda.heap;

import ch6.classfile.ClassFile;
import ch6.classfile.ConstantPool;
import ch6.rtda.LocalVars;
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

    private RTConstantPool constantPool;

    private Field[] fields;

    private Method[] methods;

    private KlassLoader loader;

    private Klass superClass;

    private Klass[] interfaces;

    private  int instanceSlotCount;

    private int staticSlotCount;

    private LocalVars staticVars;

    public Klass(ClassFile cf){
        this.accessFlags=cf.getAccessFlags();
        this.name=cf.getClassName();
        this.superClassName=cf.getSuperClassName();
        this.interfaceNames=cf.getInterfaceName();
        /*
        class.constantPool = newConstantPool(class, cf.ConstantPool()) // 见
        6.2小节
        class.fields = newFields(class, cf.Fields()) // 见
        6.1.2小节
        class.methods = newMethods(class, cf.Methods()) // 见
        6.1.3小节
         */
        this.constantPool=new RTConstantPool(this,cf.getConstantPool());
        this.fields=Field.newFields(this,cf.getFields());
        this.methods=Method.newMethods(this,cf.getMethods());
    }

    /**
     * 是否有权限访问other
     * @param other
     * @return
     */
    public boolean isAccessibleTo(Klass other){
        return this.isPublic()||this.getPackageName().equals(other.getPackageName());
    }


    /**
     * 获取包名
     * @return
     */
    public String getPackageName(){
        int i=this.name.lastIndexOf("/");
        if(i>0){
            return this.name.substring(0,i);
        }
        return "";
    }


    //访问权限确认
    public boolean isPublic(){return (accessFlags&AcessFlags.ACC_PUBLIC)!=0;}

    public boolean isFinal(){
        return (accessFlags&AcessFlags.ACC_FINAL)!=0;
    }

    public boolean isSuper(){
        return (accessFlags&AcessFlags.ACC_SUPER)!=0;
    }

    public boolean isInterface(){
        return (accessFlags&AcessFlags.ACC_INTERFACE)!=0;
    }

    public boolean isAbstract(){
        return (accessFlags&AcessFlags.ACC_ABSTRACT)!=0;
    }

    public boolean isSynthetic(){
        return (accessFlags&AcessFlags.ACC_SYNTHETIC)!=0;
    }

    public boolean isAnnotation(){
        return (accessFlags&AcessFlags.ACC_ANNOTATION)!=0;
    }

    public boolean isEnumn(){
        return (accessFlags&AcessFlags.ACC_ENUM)!=0;
    }





    //getters

    public int getAccessFlags() {
        return accessFlags;
    }

    public String getName() {
        return name;
    }

    public String getSuperClassName() {
        return superClassName;
    }

    public String[] getInterfaceNames() {
        return interfaceNames;
    }

    public RTConstantPool getConstantPool() {
        return constantPool;
    }

    public Field[] getFields() {
        return fields;
    }

    public Method[] getMethods() {
        return methods;
    }

    public KlassLoader getLoader() {
        return loader;
    }

    public Klass getSuperClass() {
        return superClass;
    }

    public Klass[] getInterfaces() {
        return interfaces;
    }

    public int getInstanceSlotCount() {
        return instanceSlotCount;
    }

    public int getStaticSlotCount() {
        return staticSlotCount;
    }

    public LocalVars getStaticVars() {
        return staticVars;
    }



    //setters

    public void setAccessFlags(int accessFlags) {
        this.accessFlags = accessFlags;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSuperClassName(String superClassName) {
        this.superClassName = superClassName;
    }

    public void setInterfaceNames(String[] interfaceNames) {
        this.interfaceNames = interfaceNames;
    }

    public void setConstantPool(RTConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    public void setFields(Field[] fields) {
        this.fields = fields;
    }

    public void setMethods(Method[] methods) {
        this.methods = methods;
    }

    public void setLoader(KlassLoader loader) {
        this.loader = loader;
    }

    public void setSuperClass(Klass superClass) {
        this.superClass = superClass;
    }

    public void setInterfaces(Klass[] interfaces) {
        this.interfaces = interfaces;
    }

    public void setInstanceSlotCount(int instanceSlotCount) {
        this.instanceSlotCount = instanceSlotCount;
    }

    public void setStaticSlotCount(int staticSlotCount) {
        this.staticSlotCount = staticSlotCount;
    }

    public void setStaticVars(LocalVars staticVars) {
        this.staticVars = staticVars;
    }
}
