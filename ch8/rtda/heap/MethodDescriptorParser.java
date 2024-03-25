package ch8.rtda.heap;

import java.util.Objects;

public class MethodDescriptorParser {

    private String raw;

    private int offset;
    private MethodDescriptor parsed;

    public  MethodDescriptor parseMethodDescriptor(String descriptor){
        return this.parse(descriptor);
    }

    private MethodDescriptor parse(String descriptor){
        this.raw=descriptor;
        this.parsed=new MethodDescriptor();
        this.startParams();;
        this.parseParamTypes();
        this.endParams();
        this.parseReturnType();
        this.finish();
        return this.parsed;
    }

    private void startParams(){
        if(this.readUint8()!='('){
            this.causePanic();
        }
    }

    private void endParams(){
        if(this.readUint8()!=')'){
            this.causePanic();
        }
    }

    private void finish(){
        if(this.offset!=this.raw.length()){
            this.causePanic();
        }
    }

    private void causePanic(){
        System.out.println("BAD descriptor: "+this.raw);
        System.exit(0);
    }
    private char readUint8(){
        char b=this.raw.charAt(this.offset);
        this.offset++;
        return b;
    }

    private void unreadUint8(){
        this.offset--;
    }


    private void parseParamTypes(){
        while(true){
            String t=this.parseFieldType();
            if(!t.isEmpty()){
                this.parsed.addParameterType(t);
            }else{
                break;
            }
        }
    }

    private void parseReturnType(){
        if(this.readUint8()=='V'){
            this.parsed.setReturnType("V");
            return;
        }
        this.unreadUint8();
        String t=this.parseFieldType();
        if(!Objects.equals(t, "")){
            this.parsed.setReturnType(t);
            return;
        }
        this.causePanic();
    }

    private String parseFieldType(){
        switch (this.readUint8()){
            case 'B'->{return "B";}
            case 'C'->{return "C";}
            case 'D'->{return "D";}
            case 'F'->{return "F";}
            case 'I'->{return "I";}
            case 'J'->{return "J";}
            case 'S'->{return "S";}
            case 'Z'->{return "Z";}
            case 'L'->{return this.parseObjectType();}
            case '['->{return this.parseArrayType();}
            default->{this.unreadUint8(); return "";}
        }
    }

    private String parseObjectType(){
        String unread=this.raw.substring(this.offset);
        int semicolonIndex=unread.indexOf(';');
        if(semicolonIndex==-1){
            this.causePanic();
            return "";
        }else{
            int objStart=this.offset-1;
            int objEnd=this.offset+semicolonIndex+1;
            this.offset=objEnd;
            return this.raw.substring(objStart,objEnd);
        }
    }

    private String parseArrayType(){
        int arrStart=this.offset-1;
        this.parseFieldType();
        int arrEnd=this.offset;
        return this.raw.substring(arrStart,arrEnd);
    }
}
