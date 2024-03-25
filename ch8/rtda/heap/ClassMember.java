package ch8.rtda.heap;

import ch8.classfile.MemberInfo;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/16/17:12
 * @Description:
 */
public class ClassMember {
    protected int accessFlags;

    protected String name;

    protected String descriptor;

    protected Klass klass;

    public ClassMember(Klass klass) {
        this.klass = klass;
    }

    public void copyMemberInfo(MemberInfo memberInfo){
        accessFlags=memberInfo.getAccessFlags();
        name=memberInfo.getName();
        descriptor=memberInfo.getDescriptor();
    }

    public boolean isAccessibleTo(Klass d){
        if(this.isPublic()){
            return true;
        }
        Klass c=this.klass;
        if(this.isProtected()){
            return d==c||d.isSubClassOf(c)||c.getPackageName().equals(d.getPackageName());
        }
        if(!this.isPrivate()){
            return c.getPackageName().equals(d.getPackageName());
        }
        return d==c;
    }


    //访问控制
    public boolean isPublic(){return (accessFlags&AcessFlags.ACC_PUBLIC)!=0;}

    public boolean isProtected(){return (accessFlags&AcessFlags.ACC_PROTECTED)!=0;}

    public boolean isPrivate(){return (accessFlags&AcessFlags.ACC_PRIVATE)!=0;}

    public boolean isStatic(){return (accessFlags&AcessFlags.ACC_STATIC)!=0;}

    public boolean isAbstract(){return (accessFlags&AcessFlags.ACC_ABSTRACT)!=0;}

    public boolean isNative(){return (accessFlags&AcessFlags.ACC_NATIVE)!=0;}
}
