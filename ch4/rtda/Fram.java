package ch4.rtda;

public class Fram {
    private Fram lower;

    private LocalVars localVars;

    private OperandStack operandStack;


    public Fram(int maxLocals,int maxStack) {
        localVars=new LocalVars(maxLocals);
        operandStack=new OperandStack(maxStack);
    }

    public Fram getLower() {
        return lower;
    }

    public void setLower(Fram lower) {
        this.lower = lower;
    }

    public LocalVars getLocalVars() {
        return localVars;
    }

    public OperandStack getOperandStack() {
        return operandStack;
    }
}
