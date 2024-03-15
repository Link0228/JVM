package ch20.classpath;

import java.util.ArrayList;
import java.util.List;

public class CompositeEntry extends Entry {
    List<Entry> composite;//entry的集合

    String pathList;
    public CompositeEntry(){

    }
    public  CompositeEntry(String path){
        pathList=path;
        composite=new ArrayList<Entry>();
        //路径分隔
        String[] pathArr=path.split(Entry.pathListSeparator);
        //对每个path，分别创建entry
        for(String p:pathArr){
            composite.add(Entry.newEntry(p));
        }
    }
    @Override
    byte[] readClass(String className) {
        for(Entry entry:composite){
            byte[] data=entry.readClass(className);
            //return new byte[0];
            if (data.length!=0) {
                return data;
            }
        }
        System.out.println("class not found: " + className);
        return new byte[0];
    }

    @Override
    String fileToString() {

        return pathList;
    }
}
