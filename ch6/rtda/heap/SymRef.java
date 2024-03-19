package ch6.rtda.heap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/16/19:01
 * @Description:
 */
public class SymRef {
   protected RTConstantPool cp;
   protected String className;

   protected Klass klass;

   public Klass resolvedClass(){
      if(klass==null){
         resolveClassRef();
      }
      return klass;
   }

   public void resolveClassRef(){
      Klass d=cp.getKlass();
      Klass c=d.getLoader().loadClass(className);
      if(!c.isAccessibleTo(d)){
         System.out.println("java.lang.IllegalAccessError");
         System.exit(0);
      }
      this.klass=c;
   }


}
