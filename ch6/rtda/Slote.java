package ch6.rtda;

import ch6.rtda.heap.Objext;

public class Slote {
    private int num;
    private Objext ref;

//    public Slote() {
//        this.num = 0;
//        this.ref = new Objext();
//    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setRef(Objext ref) {
        this.ref = ref;
    }

    public int getNum() {
        return num;
    }

    public Objext getRef() {
        return ref;
    }
}
