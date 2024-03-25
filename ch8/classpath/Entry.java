package ch8.classpath;

public abstract class Entry {
    //路径分隔符
    public static final String pathListSeparator=";";




    //寻找和加载class文件
    abstract byte[] readClass(String className);


    //返回变量的字符串表示
    public abstract String fileToString();

    static Entry newEntry(String path){
        if (path.contains(pathListSeparator)) {
            return new CompositeEntry(path);
        }
        if (path.endsWith("*")) {
            return new WildcardEntry(path);
        }
        if (path.endsWith(".jar") || path.endsWith( ".JAR") ||
                path.endsWith(".zip") || path.endsWith( ".ZIP")) {
            return new ZipJarEntry(path);
        }
        return new DirEntry(path);
    }
}
