package ch7.rtda.heap;

import ch7.classfile.constantinfo.ConstantClassInfo;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/16/19:06
 * @Description:
 */
public class ClassRef extends SymRef{
    public ClassRef(RTConstantPool cp, ConstantClassInfo classinfo) {
        this.cp=cp;
        this.className=classinfo.gertName();
    }
}
