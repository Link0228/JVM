package ch7.instructions.base;

import ch7.rtda.Fram;
import ch7.rtda.Thred;
import ch7.rtda.heap.Klass;
import ch7.rtda.heap.Method;

public interface ClassInitLogic {
    static void initClass(Thred thread, Klass klass){
        klass.startInit();
        scheduleClinit(thread,klass);
        initSuperClass(thread,klass);
    }

    static void scheduleClinit(Thred thread, Klass klass){
        Method clinit=klass.getClinitMethod();
        if(clinit!=null){
            // exec <clinit>
            Fram newFrame=thread.newFrame(clinit);
            thread.pushFram(newFrame);
        }
    }

    static void initSuperClass(Thred thread, Klass klass){
        if(!klass.isInterface()){
            Klass superClass=klass.getSuperClass();
            if(superClass!=null&&!superClass.isInitStarted()){
                initClass(thread,superClass);
            }
        }
    }
}
