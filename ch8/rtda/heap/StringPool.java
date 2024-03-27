package ch8.rtda.heap;

import java.util.HashMap;
import java.util.Map;

public class StringPool {
    private Map<String,Objext> internedStrings;

    public StringPool(){
        internedStrings=new HashMap<>();
    }

    public Objext jString(KlassLoader loader,String jaStr){
        if(internedStrings.containsKey(jaStr)){
            return internedStrings.get(jaStr);
        }
        Objext jChars=new Objext(loader.loadClass("[C"),jaStr);
        Objext jStr=loader.loadClass("java/lang/String").newObjext();
        jStr.setRefVar("value", "[C", jChars);
        internedStrings.put(jaStr,jStr);
        return jStr;
    }

    public String goString(Objext jStr){
        Objext charArrObject=jStr.getRefVar("value", "[C");
        return new String(charArrObject.getChars());
    }
}
