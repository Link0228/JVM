package ch20.instructions.extended;

import ch20.instructions.base.*;
import ch20.instructions.loads.aload.ALOAD;
import ch20.instructions.loads.dload.DLOAD;
import ch20.instructions.loads.fload.FLOAD;
import ch20.instructions.loads.iload.ILOAD;
import ch20.instructions.loads.lload.LLOAD;
import ch20.instructions.math.iinc.IINC;
import ch20.instructions.stores.astore.ASTORE;
import ch20.instructions.stores.dstore.DSTORE;
import ch20.instructions.stores.fstore.FSTORE;
import ch20.instructions.stores.istore.ISTORE;
import ch20.instructions.stores.lstore.LSTORE;
import ch20.rtda.Fram;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/15/14:27
 * @Description:
 */
public class WIDE extends Instruction {

    private Index8Instruction modifiedInstruction;

    private IINC iinc;


    private boolean iincFlag=false;

    /**
     * @param reader
     */
    @Override
    public void fetchOperands(BytecodeReader reader) {
        int opcode=reader.readUint8();
        switch (opcode){
            case 0x15-> {
                Index8Instruction inst=new ILOAD();
                inst.index= reader.readUint16();
                modifiedInstruction=inst;
            } // iload
            case 0x16-> {
                Index8Instruction inst=new LLOAD();
                inst.index= reader.readUint16();
                modifiedInstruction=inst;
            } // lload
            case 0x17-> {
                Index8Instruction inst=new FLOAD();
                inst.index= reader.readUint16();
                modifiedInstruction=inst;
            } // fload
            case 0x18-> {
                Index8Instruction inst=new DLOAD();
                inst.index= reader.readUint16();
                modifiedInstruction=inst;
            } // dload
            case 0x19-> {
                Index8Instruction inst=new ALOAD();
                inst.index= reader.readUint16();
                modifiedInstruction=inst;
            } // aload
            case 0x36-> {
                Index8Instruction inst=new ISTORE();
                inst.index= reader.readUint16();
                modifiedInstruction=inst;
            } // istore
            case 0x37-> {
                Index8Instruction inst=new LSTORE();
                inst.index= reader.readUint16();
                modifiedInstruction=inst;
            } // lstore
            case 0x38-> {
                Index8Instruction inst=new FSTORE();
                inst.index= reader.readUint16();
                modifiedInstruction=inst;
            } // fstore
            case 0x39-> {
                Index8Instruction inst=new DSTORE();
                inst.index= reader.readUint16();
                modifiedInstruction=inst;
            } // dstore
            case 0x3a-> {
                Index8Instruction inst=new ASTORE();
                inst.index= reader.readUint16();
                modifiedInstruction=inst;
            } // astore
            case 0x84-> {
                iincFlag=true;
                IINC inst=new IINC();
                inst.index=reader.readUint16();
                inst.iconst= (int)reader.readInt16();
                iinc=inst;
            } // iinc
            case 0xa9-> {
                throw new RuntimeException("Unsupported opcode: 0xa9!");
            }  // ret
        }
    }

    /**
     * @param fram
     */
    @Override
    public void execute(Fram fram) {
        if(iincFlag){
            iinc.execute(fram);
        }else{
            modifiedInstruction.execute(fram);
        }
    }
}
