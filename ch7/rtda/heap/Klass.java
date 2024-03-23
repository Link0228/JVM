package ch7.rtda.heap;

import ch7.classfile.ClassFile;
import ch7.classfile.ConstantPool;
import ch7.rtda.LocalVars;
import ch7.rtda.Slote;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/15/21:24
 * @Description:
 */
public class Klass {
    private int accessFlags;// 修饰符
    private String name;// 类名

    private String superClassName;// 超类名

    private String[] interfaceNames;// 接口名

    private RTConstantPool constantPool;// 当前运行常量池

    private Field[] fields;// 字段

    private Method[] methods;// 方法

    private KlassLoader loader;// 类加载器

    private Klass superClass;// 超类

    private Klass[] interfaces;// 接口

    private  int instanceSlotCount;// 实例数

    private int staticSlotCount;// 静态字段方法数

    private LocalVars staticVars;// 静态字段方法表

    private boolean initStarted;// 初始化标志

    public Klass(ClassFile cf){
        this.accessFlags=cf.getAccessFlags();
        this.name=cf.getClassName();
        this.superClassName=cf.getSuperClassName();
        this.interfaceNames=cf.getInterfaceName();
        this.constantPool=new RTConstantPool(this,cf.getConstantPool());
        this.fields=Field.newFields(this,cf.getFields());
        this.methods=Method.newMethods(this,cf.getMethods());
    }

    /**
     * other是否有权限访问
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

    /**
     * 创建新实例
     * @return
     */
    public Objext newObjext(){
        return new Objext(this);
    }



    //class_hierarchy.go

    /**
     * 在三种情况下，S类型的引用值可以赋值给T类型：S
     * 和T是同一类型；T是类且S是T的子类；或者T是接口
     * 且S实现了T接口
     * @param other
     * @return
     */
    public boolean isAssignableFrom(Klass other){
        Klass t=this;
        Klass s=other;
        if(s==t){
            return true;
        }
        if(!t.isInterface()){
            return s.isSubClassOf(t);
        }else {
            return s.isImplements(t);
        }
    }

    /**
     * 子类判断
     * @param other
     * @return
     */
    public boolean isSubClassOf(Klass other){
        for(Klass c=this.getSuperClass();c!=null;c=c.getSuperClass()){
            if(c==other){
                return true;
            }
        }
        return false;
    }

    /**
     * 实现判断
     * @param iface
     * @return
     */
    public boolean isImplements(Klass iface){
        for(Klass c=this;c!=null;c=c.getSuperClass()){
            for(Klass i:c.getInterfaces()){
                if(i==iface||i.isSubInterfaceOf(iface)){
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 子接口判断
     * @param iface
     * @return
     */
    public boolean isSubInterfaceOf(Klass iface){
        for(Klass superInterface:interfaces){
            if(superInterface==iface||superInterface.isSubInterfaceOf(iface)){
                return true;
            }
        }
        return false;
    }

    public boolean isSuperClassOf(Klass other){
        return other.isSubClassOf(this);
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

    /**
     * 只是调用getStaticMethod()方法
     * @return
     */
    public Method getMainMethod(){
        return this.getStaticMethod("main","([Ljava/lang/String;)V");
    }

    public Method getStaticMethod(String name,String descriptor){
        for(Method method:this.methods){
            if(method.isStatic()&&method.name.equals(name)&&method.descriptor.equals(descriptor)){
                return method;
            }
        }
        return null;
    }

    public Method getClinitMethod(){
        return this.getStaticMethod("<clinit>", "()V");
    }

    public boolean isInitStarted() {
        return initStarted;
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

    public void startInit(){
        this.initStarted=true;
    }
}
