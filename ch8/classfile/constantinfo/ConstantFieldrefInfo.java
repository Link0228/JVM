package ch8.classfile.constantinfo;

import ch8.classfile.ConstantPool;

/**
 * 字段符号引用
 */
public class ConstantFieldrefInfo extends ConstantMemberrefInfo{
    public ConstantFieldrefInfo(ConstantPool cp, byte tag) {
        super(cp, tag);
    }
}
