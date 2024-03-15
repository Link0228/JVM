package ch5.instructions.stores;

import ch5.rtda.Fram;
import ch5.rtda.Objext;

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
}
