package ch8.classfile.constantinfo;

import ch8.classfile.ConstantPool;


/**
 * 普通（非接口）方法符号引用
 */
public class ConstantMethodrefInfo extends ConstantMemberrefInfo{
    public ConstantMethodrefInfo(ConstantPool cp, byte tag) {
        super(cp, tag);
    }
}
