package ch4.rtda;

public class Stak {
    private int maxSize;
    private int size;
    Fram _top;


    public Stak(int maxSize) {
        this.maxSize = maxSize;
    }

    public void push(Fram fram){
        if(size>maxSize){
            System.out.println("java.lang.StackOverflowError");
            System.exit(0);
        }
        if(_top!=null){
            fram.setLower(_top);
        }
        _top=fram;
        size++;
    }

    public Fram pop(){
        if(_top==null){
            System.out.println("jvm stack is empty!");
            System.exit(0);
        }
        Fram top=_top;
        _top=top.getLower();
        top.setLower(null);
        size--;
        return top;
    }

    public Fram top(){
        if(_top==null){
            System.out.println("jvm stack is empty!");
            System.exit(0);
        }
        return _top;
    }
}
