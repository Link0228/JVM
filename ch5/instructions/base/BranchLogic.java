package ch5.instructions.base;

import ch5.rtda.Fram;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Link0228
 * @Date: 2024/03/15/10:28
 * @Description:
 */
public class BranchLogic {
    public static void branch(Fram fram,int offset){
        int pc=fram.getThread().getPc();
        int nextPC=pc+offset;
        fram.setNextPC(nextPC);
    }
}
