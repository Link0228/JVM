package ch6.rtda;

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

    public Fram newFrame(int maxLocals,int maxStack){
        return new Fram(maxLocals,maxStack,this);
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }
}
