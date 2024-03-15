package ch5.rtda;

public class Fram {
    private Fram lower;

    private LocalVars localVars;

    private OperandStack operandStack;

    private Thred thread;

    private int nextPC;


    public Fram(int maxLocals,int maxStack,Thred thread) {
        localVars=new LocalVars(maxLocals);
        operandStack=new OperandStack(maxStack);
        this.thread=thread;
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

    public int getNextPC() {
        return nextPC;
    }

    public void setNextPC(int nextPC) {
        this.nextPC = nextPC;
    }

    public Thred getThread() {
        return thread;
    }
}
