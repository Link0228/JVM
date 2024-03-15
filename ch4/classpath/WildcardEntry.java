package ch4.classpath;

import java.io.File;
import java.util.ArrayList;

public class WildcardEntry extends Entry {

    String baseDir;
    //定义一个CompositeEntry类
    CompositeEntry CE;

    public WildcardEntry(String path){
        baseDir=path.substring(0,path.length()-1);
        File file=new File(baseDir);
        File[] fs=file.listFiles();
        CE=new CompositeEntry();
        CE.composite=new ArrayList<Entry>();
        if(fs==null){
            return;
        }
        for(File f:fs){
            if(!f.isDirectory()){
              if(f.getName().endsWith(".jar")||f.getName().endsWith(".JAR")){
                  CE.composite.add(Entry.newEntry(baseDir+f.getName()));
              }
            }
        }
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
