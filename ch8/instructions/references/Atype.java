package ch8.instructions.references;

import ch8.rtda.heap.Klass;
import ch8.rtda.heap.KlassLoader;

public interface Atype {
     static final int AT_BOOLEAN = 4;
     static final int AT_CHAR = 5;
     static final int AT_FLOAT = 6;
     static final int AT_DOUBLE = 7;
     static final int AT_BYTE = 8;
     static final int AT_SHORT = 9;
     static final int AT_INT = 10;
     static final int AT_LONG = 11;

     static Klass getPrimitiveArrayClass(KlassLoader loader,int atype){
         switch (atype){
             case AT_BOOLEAN->{return loader.loadClass("[Z");}
             case AT_BYTE->{ return loader.loadClass("[B");}
             case AT_CHAR->{return loader.loadClass("[C");}
             case AT_SHORT->{return loader.loadClass("[S");}
             case AT_INT->{return loader.loadClass("[I");}
             case AT_LONG->{return loader.loadClass("[J");}
             case AT_FLOAT->{return loader.loadClass("[F");}
             case AT_DOUBLE->{return loader.loadClass("[D");}
             default-> {
                 System.out.println("Invalid atype!");
                 System.exit(0);
                 return null;
             }
         }
     }
}
