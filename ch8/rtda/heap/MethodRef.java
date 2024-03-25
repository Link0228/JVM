package ch8.rtda.heap;

import ch8.classfile.constantinfo.ConstantMemberrefInfo;
import ch8.classfile.constantinfo.ConstantMethodrefInfo;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/17/14:50
 * @Description:
 */
public class MethodRef extends MemberRef{
    private Method method;

    public MethodRef(RTConstantPool cp, ConstantMethodrefInfo refInfo) {
        this.cp=cp;
        this.copyMemberRefInfo((ConstantMemberrefInfo) refInfo);
    }

    public String getName(){
        return this.name;
    }

    public String getDescriptor(){
        return this.descriptor;
    }


    /**
     * 如果还没有解析过符号引用，调用resolveMethodRef（）
     * 方法进行解析，否则直接返回方法指针
     * @return
     */
    public Method resolvedMethod(){
        if(this.method==null){
            resolveMethodRef();
        }
        return this.method;
    }

    public void resolveMethodRef(){
        Klass d=this.cp.getKlass();
        Klass c=this.resolvedClass();
        if(c.isInterface()){
            System.out.println("java.lang.IncompatibleClassChangeError");
            System.exit(0);
        }
        Method method=lookupMethod(c,this.name,this.descriptor);
        if(method==null){
            System.out.println("java.lang.NoSuchMethodError");
            System.exit(0);
        }
        if(!method.isAccessibleTo(d)){
            System.out.println("java.lang.IllegalAccessError");
            System.exit(0);
        }
        this.method=method;
    }

    public Method lookupMethod(Klass klass,String name,String descriptor){
        Method method=MLK.lookupMethodInClass(klass,name,descriptor);
        if(method==null){
            method=MLK.lookupMethodInInterfaces(klass.getInterfaces(),name,descriptor);
        }
        return method;
    }
}
