package ch6.rtda;

import ch6.rtda.heap.Method;

import java.util.Deque;

public class Thred {
    private int pc;

    Stak stak;


    public Thred() {
        stak=new Stak(1024);
    }

    public void pushFram(Fram fram){
        stak.push(fram);
    }

    public Fram popFram(){
        return stak.pop();
    }

    public Fram getCurrentFram(){
        return stak.top();
    }

    public Fram newFrame(Method method){
        return new Fram(this,method);
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }
}
