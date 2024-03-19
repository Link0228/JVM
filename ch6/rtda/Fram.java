package ch6.rtda;

import ch6.rtda.heap.Method;

public class Fram {
    private Fram lower;//栈用链表实现

    private LocalVars localVars;

    private OperandStack operandStack;

    private Thred thread;

    private int nextPC;

    private Method method;//当前方法


    public Fram(Thred thread,Method method) {
        this.method=method;
        this.thread=thread;
        localVars=new LocalVars(method.getMaxLocals());
        operandStack=new OperandStack(method.getMaxStack());
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

    public Method getMethod() {
        return method;
    }
}
