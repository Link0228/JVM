package ch7.rtda.heap;

import ch7.classfile.constantinfo.ConstantMemberrefInfo;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/16/19:58
 * @Description:
 */
public class MemberRef extends SymRef{
    protected String name;
    protected String descriptor;
    public void copyMemberRefInfo(ConstantMemberrefInfo refInfo ){
        this.className=refInfo.getClassName();
        this.name=refInfo.getNameAndDescriptor()[0];
        this.descriptor=refInfo.getNameAndDescriptor()[1];
    }
}
