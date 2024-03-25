package ch8.rtda.heap;

import ch8.classfile.ClassFile;
import ch8.classfile.ConstantPool;
import ch8.rtda.LocalVars;
import ch8.rtda.Slote;

import java.util.HashMap;
import java.util.Map;

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

    private static final Map<String,String> primitiveTypes=new HashMap<String,String>(){{
        put("void","V");
        put("boolean","B");
        put("byte","B");
        put("short","S");
        put("int","I");
        put("long","J");
        put("char","C");
        put("float","F");
        put("double","D");
    }};

    public Klass(int accessFlags,
                 String name,
                 KlassLoader loader,
                 boolean initStarted,
                 Klass superClass,
                 Klass[] interfaces){
        this.accessFlags=accessFlags;
        this.name=name;
        this.loader=loader;
        this.initStarted=initStarted;
        this.superClass=superClass;
        this.interfaces=interfaces;

    }

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
        if(!s.isArray()){
            if(!s.isInterface()){
                if(!t.isInterface()){
                    return s.isSubClassOf(t);
                }else{
                    return s.isImplements(t);
                }
            }else{
                if(!t.isInterface()){
                    return t.isJlObject();
                }else{
                    return t.isSuperInterfaceOf(s);
                }
            }
        }else{
            if(!t.isArray()){
                if(!t.isInterface()){
                    return t.isJlObject();
                }else{
                    return t.isJlCloneable()||t.isJioSerializable();
                }
            }else{
                Klass sc=s.componentClass();
                Klass tc=t.componentClass();
                return sc==tc||tc.isAssignableFrom(sc);
            }
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


    /**
     * 父接口判断
     * @param iface
     * @return
     */
    public boolean isSuperInterfaceOf(Klass iface){
        return iface.isSubInterfaceOf(this);
    }


    /**
     * 父类判断
     * @param other
     * @return
     */
    public boolean isSuperClassOf(Klass other){
        return other.isSubClassOf(this);
    }

    //是否为数组
    public boolean isArray(){
        return name.charAt(0)=='[';
    }

    public Objext newArray(int count){
        if(!this.isArray()){
            System.out.println("Not array class: " +name);
            System.exit(0);
            return null;
        }
        switch (name){
            case "[Z", "[B" ->{return new Objext(this, new byte[count]);}
            case "[C"->{return new Objext(this, new char[count]);}
            case "[S"->{return new Objext(this, new short[count]);}
            case "[I"->{return new Objext(this, new int[count]);}
            case "[J"->{return new Objext(this, new long[count]);}
            case "[F"->{return new Objext(this, new float[count]);}
            case "[D"->{return new Objext(this, new double[count]);}
            default->{return new Objext(this,new Object[count]);}
        }
    }


    /**
     * 返回数组类的元素类型
     * @return
     */
    public Klass componentClass(){
        String componentClassName=getComponentClassName(name);
        return loader.loadClass(componentClassName);
    }


    private String getComponentClassName(String className){
        if(className.charAt(0)=='['){
            String componentTypeDescriptor=className.substring(1);
            return toClassName(componentTypeDescriptor);
        }
        System.out.println("Not array: " + className);
        System.exit(0);
        return null;
    }

    private String toClassName(String descriptor){
        if(descriptor.charAt(0)=='['){// array
            return descriptor;
        }
        if(descriptor.charAt(0)=='L'){
            return descriptor.substring(1,descriptor.length()-1);
        }
        for(String className:primitiveTypes.keySet()){
            if(primitiveTypes.get(className).equals(descriptor)){
                return className;
            }
        }
        System.out.println("Invalid descriptor: "+descriptor);
        System.exit(0);
        return null;
    }


    /**
     * 是否是class
     * @return
     */
    public boolean isJlObject(){
        return name.equals("java/lang/Object");
    }

    /**
     * 是否是Cloneable接口
     * @return
     */
    public boolean isJlCloneable(){
        return name.equals("java/lang/Cloneable");
    }

    /**
     * 是否是Serializable接口
     * @return
     */
    public boolean isJioSerializable(){
        return name.equals("java/io/Serializable");
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

    public Klass getArrayClass(){
        String arrayClassName=getArrayClassName(name);
        return loader.loadClass(arrayClassName);
    }

    private String getArrayClassName(String className){
        return "["+toDescriptor(className);
    }

    private String toDescriptor(String className){
        if(className.charAt(0)=='['){
            return className;
        }
        else{
            switch (className){
                case "void"->{return "V";}
                case "boolean"->{return "Z";}
                case "byte"->{return "B";}
                case "short"->{return "S";}
                case "int"->{return "I";}
                case "long"->{return "J";}
                case "char"->{return "C";}
                case "float"->{return "F";}
                case "double"->{return "D";}
                default -> {
                    return "L"+className+";";
                }
            }
        }
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
