package ch7.classpath;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipJarEntry extends Entry {

    String absPath;

    public ZipJarEntry(String path){
        File dir=new File(path);
        if(dir.exists()){
            absPath=dir.getAbsolutePath();
        }else{
            System.out.println("ZipJarEntry:path does not exist");
        }
    }
    @Override
    byte[] readClass(String className){
        String zipFilePath=absPath;
        byte[] fileData;
        try (ZipFile zipFile = new ZipFile(zipFilePath)) {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                //寻找class文件
                if (entry.getName().equals(className)) {
                    try {
                        // 获取ZIP文件条目的输入流
                        InputStream inputStream = zipFile.getInputStream(entry);

                        // 将文件内容读取到字节数组
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byte[] buffer = new byte[1024];
                        int len;
                        while ((len = inputStream.read(buffer)) != -1) {
                            byteArrayOutputStream.write(buffer, 0, len);
                        }

                        fileData = byteArrayOutputStream.toByteArray();
                        //System.out.println("File: " + entry.getName());
                        //System.out.println("File Size: " + fileData.length + " bytes");

                        // 可以在这里对fileData进行进一步处理

                        inputStream.close();
                        return fileData;
                    } catch (IOException e) {
                        System.out.println("ZipJarEntry:class read error");
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("ZipJarEntry:zip read error");
            e.printStackTrace();
        }
        System.out.println("ZipJarEntry:class not found yet!");
        return new byte[0];
    }

    @Override
    public String fileToString() {
        return absPath;
    }
}
