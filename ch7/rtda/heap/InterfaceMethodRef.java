package ch7.rtda.heap;

import ch7.classfile.constantinfo.ConstantInterfaceMethodrefInfo;
import ch7.classfile.constantinfo.ConstantMemberrefInfo;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/17/14:52
 * @Description:
 */
public class InterfaceMethodRef extends MemberRef{
    private Method method;

    public InterfaceMethodRef(RTConstantPool cp, ConstantInterfaceMethodrefInfo refInfo) {
        this.cp=cp;
        this.copyMemberRefInfo((ConstantMemberrefInfo) refInfo);
    }

    public Method resolvedInterfaceMethod(){
        if(this.method==null){
            this.resolveInterfaceMethodRef();
        }
        return this.method;
    }

    private void resolveInterfaceMethodRef(){
        Klass d=this.cp.getKlass();
        Klass c=this.resolvedClass();
        if(!c.isInterface()){
            System.out.println("java.lang.IncompatibleClassChangeError");
            System.exit(0);
        }
        Method method=lookupInterfaceMethod(c,this.name,this.descriptor);
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

    private Method lookupInterfaceMethod(Klass iface,String name,String descriptor){
        for(Method method:iface.getMethods()){
            if(method.name.equals(name)&&method.descriptor.equals(descriptor)){
                return method;
            }
        }
        return MLK.lookupMethodInInterfaces(iface.getInterfaces(),name,descriptor);
    }

    public String getName(){
        return this.name;
    }

    public String getDescriptor(){
        return this.descriptor;
    }
}
