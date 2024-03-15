package ch3.classpath;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DirEntry extends Entry {
    String  absDir;

    public DirEntry(String path){
        File dir=new File(path);
        if(dir.exists()){
            absDir=dir.getAbsolutePath();
        }else{
            System.out.println("DirEntry:path does not exist");
        }
    }

    @Override
    byte[] readClass(String className){
        File filePath = new File(absDir,className);
        try (FileInputStream fis = new FileInputStream(filePath)) {
            // 获取文件大小
            long fileSize = fis.available();

            // 创建一个字节数组，长度为文件大小
            byte[] data = new byte[(int) fileSize];

            // 读取文件内容到字节数组
            fis.read(data);
            return data;
        }catch (IOException e) {
            System.out.println("DirEntry:class read error: " + e.getMessage());
        }
        return new byte[0];
    }

    @Override
    String fileToString() {
        return absDir;
    }
}
