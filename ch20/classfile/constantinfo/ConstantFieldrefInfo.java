package ch20.classfile.constantinfo;

import ch20.classfile.ConstantPool;

/**
 * 字段符号引用
 */
public class ConstantFieldrefInfo extends ConstantMemberrefInfo{
    public ConstantFieldrefInfo(ConstantPool cp, byte tag) {
        super(cp, tag);
    }
}
