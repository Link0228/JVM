package ch6.rtda.heap;

import ch6.rtda.LocalVars;

public class Objext {
    //TODO
    private  Klass klass;
    private LocalVars fields;

    public Objext (Klass klass){
        this.klass=klass;
        this.fields=new LocalVars(klass.getInstanceSlotCount());
    }

    public Klass getKlass() {
        return klass;
    }

    public LocalVars getFields() {
        return fields;
    }

    public boolean isInstanceOF(Klass klass){
        return klass.isAssignableFrom(this.klass);
    }
}
