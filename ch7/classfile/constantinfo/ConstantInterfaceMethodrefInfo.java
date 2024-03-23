package ch7.classfile.constantinfo;

import ch7.classfile.ConstantPool;

/**
 * 接口方法符号引用
 */
public class ConstantInterfaceMethodrefInfo extends ConstantMemberrefInfo{
    public ConstantInterfaceMethodrefInfo(ConstantPool cp, byte tag) {
        super(cp, tag);
    }
}
