package ch6.rtda.heap;

import ch6.classfile.constantinfo.ConstantInterfaceMethodrefInfo;
import ch6.classfile.constantinfo.ConstantMemberrefInfo;

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
}
