package ch8.rtda.heap;


//method_lookup工具接口
public interface MLK {
    static Method lookupMethodInClass(Klass klass,String name,String descriptor){
        for(Klass c=klass;c!=null;c=c.getSuperClass()){
            for(Method method:c.getMethods()){
                if(method.name.equals(name)&&method.descriptor.equals(descriptor)){
                    return method;
                }
            }
        }
        return null;
    }

    static Method lookupMethodInInterfaces(Klass[] ifaces,String name,String descriptor){
        for (Klass iface:ifaces) {
            for(Method method:iface.getMethods()){
                if(method.name.equals(name)&&method.descriptor.equals(descriptor)){
                    return method;
                }
            }
            Method method=lookupMethodInInterfaces(iface.getInterfaces(),name,descriptor);
            if(method!=null){
                return method;
            }
        }
        return null;
    }
}
