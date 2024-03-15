package ch3;

import org.apache.commons.cli.*;

import java.util.List;

public class Cmd {
    private boolean helpFlag;//帮助命令标识
    private boolean versionFlag;//版本命令标识
    private  String cpOption;//classpath路径
    private String  className="";//class文件名
    private String[] args;//执行参数
    private String XjreOption;//jre路径
    public String getXjreOption() {
        return XjreOption;
    }

    public void setXjreOption(String xjreOption) {
        XjreOption = xjreOption;
    }

    public boolean isHelpFlag() {
        return helpFlag;
    }

    public void setHelpFlag(boolean helpFlag) {
        this.helpFlag = helpFlag;
    }

    public String getCpOption() {
        return cpOption;
    }

    public void setCpOption(String cpOption) {
        this.cpOption = cpOption;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }

    public boolean isVersionFlag() {
        return versionFlag;
    }

    public void setVersionFlag(boolean versionFlag) {
        this.versionFlag = versionFlag;
    }

    public Cmd(String[] strs){
        parser(strs);
    }

    public void parser(String[] strs) {
        CommandLineParser parser = new BasicParser();
        Options options = new Options();
        options.addOption("h", "help", false, "Print help message");
        options.addOption("?",  false, "Print help message");
        options.addOption("v", "version", false, "Print version and exit");
        options.addOption("cp", "classpath", true, "classpath");
        options.addOption("Xjre", true, "path to jre");
        // Parse the program arguments
        try
        {
            CommandLine commandLine = parser.parse(options, strs);

            //是否查看帮助
            if (commandLine.hasOption('h')) {
                this.setHelpFlag(true);
                return;
            }
            //是否查看版本
            if (commandLine.hasOption('v')) {
                this.setVersionFlag(true);
                return;
            }
            //获取class文件路径
            if (commandLine.hasOption("cp")) {
                this.setCpOption(commandLine.getOptionValue("cp"));
            }
            //获取jre路径
            if(commandLine.hasOption("Xjre")){
                System.out.println(commandLine.getOptionValue("Xjre"));
                this.setXjreOption(commandLine.getOptionValue("Xjre"));
            }
            List<String> args=commandLine.getArgList();
            if(args.size()!=0){
                this.setClassName(args.get(0));
                String[] argsTmp=new String[args.size()-1];
                for(int i=1;i<args.size();i++){
                    argsTmp[i-1]=args.get(i);
                }
                this.setArgs(argsTmp);
            }
        }
        catch(ParseException e){
            System.out.println("wrong command！");
            e.printStackTrace();
        }
    }
    //jvm启动函数暂放这里
    public void printUsage() {
        System.out.println("Usage: java [-options] class [args...]\n");
    }
}

