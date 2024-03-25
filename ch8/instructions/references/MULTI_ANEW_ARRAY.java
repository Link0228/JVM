package ch8.instructions.references;

import ch8.instructions.base.BytecodeReader;
import ch8.instructions.base.Instruction;
import ch8.instructions.loads.LoadTools;
import ch8.rtda.Fram;
import ch8.rtda.OperandStack;
import ch8.rtda.heap.ClassRef;
import ch8.rtda.heap.Klass;
import ch8.rtda.heap.Objext;
import ch8.rtda.heap.RTConstantPool;

import java.util.Arrays;

public class MULTI_ANEW_ARRAY extends Instruction {
    int index;
    int dimensions;

    /**
     * @param reader
     */
    @Override
    public void fetchOperands(BytecodeReader reader) {
            this.index=reader.readUint16();
            this.dimensions=reader.readUint8();
    }

    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        RTConstantPool cp=fram.getMethod().getKlass().getConstantPool();
        ClassRef classRef=(ClassRef) cp.getConstant(this.index).getT();
        Klass arrClass=classRef.resolvedClass();
        OperandStack stack=fram.getOperandStack();
        int[] counts=popAndCheckCounts(stack,dimensions);
        Objext arr=newMultiDimensionalArray(counts,arrClass);
        stack.pushRef(arr);
    }

    private int[] popAndCheckCounts(OperandStack stack,int dimensions){
        int[] counts=new int[dimensions];
        for(int i=dimensions-1;i>=0;i--){
            counts[i]=stack.popInt();
            if(counts[i]<0){
                System.out.println("java.lang.NegativeArraySizeException");
                System.exit(0);
            }
        }
        return counts;
    }

    private Objext newMultiDimensionalArray(int[] counts,Klass arrClass){
        int count=counts[0];
        Objext arr=arrClass.newArray(count);
        if(counts.length>1){
            Objext[] refs=arr.getRefs();
            for(int i=0;i< refs.length;i++){
                refs[i]=newMultiDimensionalArray(Arrays.copyOfRange(counts,1,counts.length),arrClass.componentClass());
            }
        }
        return arr;
    }
}
