package ch7.rtda.heap;

public class MethodDescriptor {
    private String[] parameterTypes;
    private String returnType;

    public void addParameterType(String t){
        if(parameterTypes==null){
            parameterTypes=new String[]{t};
            return;
        }
        int pLen=parameterTypes.length;
        String[] newArr=new String[pLen+1];
        System.arraycopy(parameterTypes, 0, newArr, 0, pLen);
        newArr[pLen]=t;
        parameterTypes=newArr;
    }

    public String[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(String[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }
}
