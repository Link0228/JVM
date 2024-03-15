package ch4.rtda;

import java.util.Arrays;

public class OperandStack {
    private int size;
    private Slote[] slots;

    public OperandStack(int maxStack) {
        if(maxStack>0){
            this.slots=new Slote[maxStack];
            for(int i=0;i<maxStack;i++){
                this.slots[i]=new Slote();
            }
        }else{
            this.slots=null;
        }
    }

    public void pushInt(int val){
        slots[size].setNum(val);
        size++;
    }

    public int popInt(){
        size--;
        return slots[size].getNum();
    }

    public void pushFloat(float val){
        int tmp=Float.floatToIntBits(val);
        slots[size].setNum(tmp);
        size++;
    }

    public float popFloat(){
        size--;
        int tmp=slots[size].getNum();
        return Float.intBitsToFloat(tmp);
    }

    public void pushLong(long val){
        slots[size].setNum((int)val);
        slots[size+1].setNum((int)(val>>32));
        size+=2;
    }

    public long popLong(){
        size-=2;
        int low=slots[size].getNum();
        int high=slots[size+1].getNum();
        return Integer.toUnsignedLong(high)<<32|Integer.toUnsignedLong(low);
    }

    public void pushDouble(double val){
        long tmp=Double.doubleToLongBits(val);
        pushLong(tmp);
    }

    public double popDouble(){
        long tmp=popLong();
        return Double.longBitsToDouble(tmp);
    }

    public void pushRef(Objext ref){
        slots[size].setRef(ref);
        size++;
    }

    public Objext popRef(){
        size--;
        Objext ref=slots[size].getRef();
        slots[size].setRef(null);
        return ref;
    }
}
