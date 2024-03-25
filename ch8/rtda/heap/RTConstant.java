package ch8.rtda.heap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/16/18:21
 * @Description:
 */
public class RTConstant<T> {
    private T t;
    private int tag;

    public RTConstant(T t,int tag) {
        this.t = t;
        this.tag=tag;
    }

    public T getT() {
        return t;
    }

    public int getTag() {
        return tag;
    }
}
