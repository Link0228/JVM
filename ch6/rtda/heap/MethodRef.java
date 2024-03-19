package ch6.rtda.heap;

import ch6.classfile.constantinfo.ConstantMemberrefInfo;
import ch6.classfile.constantinfo.ConstantMethodrefInfo;

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
}
