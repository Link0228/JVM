package ch4.classpath;

import java.io.File;

public class Classpath {
    Entry bootClasspath;
    Entry extClasspath;
    Entry userClasspath;


    public Classpath(String XjreOption,String cpOption){
        parseBootAndExtClasspath(XjreOption);
        parseUserClasspath(cpOption);
    }

    /**
     * 解析启动类和扩展类路径
     * @param XjreOption
     */
    public void parseBootAndExtClasspath(String XjreOption){
          String jreDir=getJreDir(XjreOption);
          // jre/lib/*
          String jreLibPath = jreDir+"/lib/*";
          bootClasspath = new WildcardEntry(jreLibPath);
          // jre/lib/ext/*
          String jreExtPath = jreDir+"/lib/ext/*";
          extClasspath = new WildcardEntry(jreExtPath);

    }

    /**
     * 优先使用用户输入的-Xjre选项作为jre目录。如果没有输入该
     * 选项，则在当前目录下寻找jre目录。如果找不到，尝试使用
     * JAVA_HOME环境变量。
     * @param XjreOption
     * @return
     */
    public String getJreDir(String XjreOption){
        File jreFile;
        if (XjreOption != null && !XjreOption .equals("")) {
            jreFile = new File(XjreOption);
            if (jreFile.exists()) {
                return XjreOption;
            }
        }

        jreFile = new File("jre");
        if (jreFile.exists()) {
            return jreFile.getAbsolutePath();
        }

        String java_home = System.getenv("JAVA_HOME");
        if (java_home != null) {
            return java_home + File.separator + "jre";
        }

        throw new RuntimeException("Can not find jre folder!");
    }

    /**
     * 创建用户Entry
     * @param cpOption
     */
    public void parseUserClasspath(String cpOption){
        if(cpOption==null||cpOption.equals("")){
            cpOption="./";
        }
        userClasspath= Entry.newEntry(cpOption);
    }


    public byte[] readClass(String className){
        className=className+".class";
        byte[] bootData=bootClasspath.readClass(className);
        //return new byte[0];
        if(bootData.length!=0){
            return bootData;
        }else {
            byte[] extData=extClasspath.readClass(className);
            if(extData.length!=0){
                return extData;
            }else{
                return userClasspath.readClass(className);
            }
        }
    }

    public String fileToString() {
        return userClasspath.fileToString();
    }
}
