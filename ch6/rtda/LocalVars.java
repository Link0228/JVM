package ch6.rtda;

import ch6.rtda.heap.Objext;

public class LocalVars {
    public Slote[] localVars;

    public LocalVars(int maxLocals) {
        if(maxLocals>0){
            this.localVars=new Slote[maxLocals];
            for(int i=0;i<maxLocals;i++){
                this.localVars[i]=new Slote();
            }
        }
        else{
            this.localVars=null;
        }
    }

    public Slote[] getLocalVars() {
        return localVars;
    }

    public void setInt(int index,int val){
        localVars[index].setNum(val);
    }

    public int getInt(int index){
       return localVars[index].getNum();
    }

    public void setFloat(int index,float val){
        int tmp=Float.floatToIntBits(val);
        localVars[index].setNum(tmp);
    }

    public float getFloat(int index){
        int tmp=localVars[index].getNum();
        return Float.intBitsToFloat(tmp);
    }

    public void setLong(int index,long val){
        localVars[index].setNum((int)val);
        localVars[index+1].setNum((int)(val>>32));
    }

    public long getLong(int index){
        int low=localVars[index].getNum();
        int high=localVars[index+1].getNum();
        return Integer.toUnsignedLong(high)<<32|Integer.toUnsignedLong(low);
    }

    /**
     * double变量可以先转成long类型，然后按照long变量来处理
     * @param index
     * @param val
     */
    public void setDouble(int index,double val){
        long tmp=Double.doubleToLongBits(val);
        setLong(index,tmp);
    }

    public double getDouble(int index){
        long tmp=getLong(index);
        return Double.longBitsToDouble(tmp);
    }

    public void setRef(int index, Objext ref){
        localVars[index].setRef(ref);
    }

    public Objext getRef(int index){
        return localVars[index].getRef();
    }
}
