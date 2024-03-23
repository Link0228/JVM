package ch7.rtda.heap;

import ch7.classfile.MemberInfo;
import ch7.classfile.attributeinfo.CodeAttribute;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/16/17:22
 * @Description:
 */
public class Method extends ClassMember{
    private int maxStack;
    private int maxLocals;
    private byte[] code;
    private int argSlotCount;

    public Method(Klass klass) {
        super(klass);
    }

    public static Method[] newMethods(Klass klass, MemberInfo[] cfMethods){
        Method[] methods=new Method[cfMethods.length];
        for(int i=0;i< cfMethods.length;i++){
            methods[i]=new Method(klass);
            methods[i].copyMemberInfo(cfMethods[i]);
            methods[i].copyAttributes(cfMethods[i]);
            methods[i].calcArgSlotCount();
        }
        return methods;
    }

    public void copyAttributes(MemberInfo cfMethod){
        CodeAttribute codeAttr= cfMethod.getCodeAttribute();
        if(codeAttr!=null){
            maxStack=codeAttr.getMaxStack();
            maxLocals=codeAttr.getMaxLocals();
            code=codeAttr.getCode();
        }
    }


    private void calcArgSlotCount(){
        MethodDescriptor parsedDescriptor=new MethodDescriptorParser().parseMethodDescriptor(this.descriptor);
        if(parsedDescriptor.getParameterTypes()!=null){
            for (String paramType : parsedDescriptor.getParameterTypes()) {
                this.argSlotCount++;
                if (paramType.equals("J") || paramType.equals("D")) {
                    this.argSlotCount++;
                }
            }
        }
        if(!this.isStatic()){
            this.argSlotCount++;
        }
    }

    public int getMaxStack() {
        return maxStack;
    }

    public void setMaxStack(int maxStack) {
        this.maxStack = maxStack;
    }

    public int getMaxLocals() {
        return maxLocals;
    }

    public void setMaxLocals(int maxLocals) {
        this.maxLocals = maxLocals;
    }

    public Klass getKlass(){
        return this.klass;
    }

    public String getName(){
        return this.name;
    }

    public String getDescriptor(){
        return this.descriptor;
    }

    public byte[] getCode() {
        return code;
    }


    public int getArgSlotCount() {
        return argSlotCount;
    }


}
