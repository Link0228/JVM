package ch3.classfile.constantinfo;

import ch3.classfile.ConstantPool;

/**
 * 接口方法符号引用
 */
public class ConstantInterfaceMethodrefInfo extends ConstantMemberrefInfo{
    public ConstantInterfaceMethodrefInfo(ConstantPool cp, byte tag) {
        super(cp, tag);
    }
}
