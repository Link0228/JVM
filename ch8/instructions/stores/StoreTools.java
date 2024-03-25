package ch8.instructions.stores;

import ch8.rtda.Fram;
import ch8.rtda.heap.Objext;

public class StoreTools {
    public static void _lstore(Fram fram,int index){
        long val=fram.getOperandStack().popLong();
        fram.getLocalVars().setLong(index,val);
    }

    public static void _istore(Fram fram,int index){
        int val=fram.getOperandStack().popInt();
        fram.getLocalVars().setInt(index,val);
    }

    public static void _fstore(Fram fram,int index){
        float val=fram.getOperandStack().popFloat();
        fram.getLocalVars().setFloat(index,val);
    }

    public static void _dstore(Fram fram,int index){
        double val=fram.getOperandStack().popDouble();
        fram.getLocalVars().setDouble(index,val);
    }

    public static void _astore(Fram fram,int index){
        Objext ref=fram.getOperandStack().popRef();
        fram.getLocalVars().setRef(index,ref);
    }

    public static void checkNotNil(Objext ref){
        if(ref==null){
            System.out.println("java.lang.NullPointerException");
            System.exit(0);
        }
    }

    public static void checkIndex(int arrLen,int index){
        if(index<0||index>=arrLen){
            System.out.println("ArrayIndexOutOfBoundsException");
            System.exit(0);
        }
    }
}
