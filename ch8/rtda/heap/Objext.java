package ch8.rtda.heap;

import ch8.rtda.LocalVars;

import java.util.Objects;

public class Objext {
    //TODO
    private  Klass klass;
    private Object data;



    public Objext (Klass klass){
        this.klass=klass;
        this.data=new LocalVars(klass.getInstanceSlotCount());
    }

    public Objext(Klass klass, Object data){
        this.klass=klass;
        this.data=data;
    }


    public Klass getKlass() {
        return klass;
    }

    public LocalVars getFields() {
        return (LocalVars)data;
    }

    public boolean isInstanceOF(Klass klass){
        return klass.isAssignableFrom(this.klass);
    }


    //array_object.go
    public byte[] getBytes(){
        return (byte[])data;
    }

    public short[] getShorts(){
        return (short[])data;
    }

    public int[] getInts(){
        return (int[]) data;
    }

    public long[] getLongs(){
        return (long[]) data;
    }

    public char[] getChars(){
        return (char[]) data;
    }

    public float[] getFloats(){
        return (float[]) data;
    }

    public double[] getDoubles(){
        return (double[]) data;
    }

    public Objext[] getRefs(){
        return (Objext[]) data;
    }

    public int getArrayLength(){
        switch (data.getClass().toString().split(" ")[1]){
            case "[B","[Z"->{return ((byte[])data).length;}
            case "[S"->{return ((short[])data).length;}
            case "[I"->{return ((int[])data).length;}
            case "[J"->{return ((long[])data).length;}
            case "[C"->{return ((char[])data).length;}
            case "[F"->{return ((float[])data).length;}
            case "[D"->{return ((double[])data).length;}
            case "[L"->{return ((Object[])data).length;}
            default -> {
                System.out.println("not array!");
                System.exit(0);
                return 0;
            }
        }
    }

}
