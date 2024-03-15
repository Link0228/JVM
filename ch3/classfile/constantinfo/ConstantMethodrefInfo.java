package ch3.classfile.constantinfo;

import ch3.classfile.ConstantPool;


/**
 * 普通（非接口）方法符号引用
 */
public class ConstantMethodrefInfo extends ConstantMemberrefInfo{
    public ConstantMethodrefInfo(ConstantPool cp, byte tag) {
        super(cp, tag);
    }
}
