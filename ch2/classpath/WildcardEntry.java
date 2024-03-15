package ch2.classpath;

import java.util.List;
import java.util.ArrayList;
import java.io.File;

public class WildcardEntry extends Entry{

    String baseDir;
    //定义一个CompositeEntry类
    CompositeEntry CE;

    public WildcardEntry(String path){
        baseDir=path.substring(0,path.length()-1);
        File file=new File(baseDir);
        File[] fs=file.listFiles();
        CE=new CompositeEntry();
        CE.composite=new ArrayList<Entry>();
        for(File f:fs){
            if(!f.isDirectory()){
              if(f.getName().endsWith(".jar")||f.getName().endsWith(".JAR")){
                  CE.composite.add(Entry.newEntry(baseDir+f.getName()));
              }
            }
        }
        System.out.println("test");
    }

    @Override
    byte[] readClass(String className) {
        return CE.readClass(className);
    }


    @Override
    String fileToString() {
        return baseDir;
    }
}
