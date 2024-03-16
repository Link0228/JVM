package ch6.instructions.loads;

import ch6.rtda.Fram;
import ch6.rtda.Objext;

public class LoadTools {
    public static void _iload(Fram fram,int index){
        int val=fram.getLocalVars().getInt(index);
        fram.getOperandStack().pushInt(val);
    }

    public static void _lload(Fram fram,int index){
        long val=fram.getLocalVars().getLong(index);
        fram.getOperandStack().pushLong(val);
    }

    public static void _fload(Fram fram,int index){
        float val=fram.getLocalVars().getFloat(index);
        fram.getOperandStack().pushFloat(val);
    }

    public static void _dload(Fram fram,int index){
        double val=fram.getLocalVars().getDouble(index);
        fram.getOperandStack().pushDouble(val);
    }

    public static void _aload(Fram fram,int index){
        Objext ref=fram.getLocalVars().getRef(index);
        fram.getOperandStack().pushRef(ref);
    }
}
