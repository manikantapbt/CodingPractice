import java.util.ArrayList;
import java.util.List;

public class GenerateIpAddress {
    static List<String> result = new ArrayList<>();
    public static void main(String[] args) {
        String ip ="25525511135";
        generateIPAddress(ip,0,0);
        for(String s:result){
            System.out.println(s);
        }
    }
    public static void generateIPAddress(String ip,int count,int beginindex){
        if(count==3){
            if(isValid(ip)){
                result.add(ip);
            }
            return;
        }
        int len = ip.length();
        String subString1=ip.substring(0,beginindex+1)+"."+ip.substring(beginindex+1,len);
        generateIPAddress(subString1,count+1,beginindex+2);

        String subString2=ip.substring(0,beginindex+2)+"."+ip.substring(beginindex+2,len);
        generateIPAddress(subString2,count+1,beginindex+3);

        String subString3=ip.substring(0,beginindex+3)+"."+ip.substring(beginindex+3,len);
        generateIPAddress(subString3,count+1,beginindex+4);


    }
    public static boolean isValid(String ip){
        String[] arr = ip.split("\\.");
        for(String s:arr){
            if(Integer.parseInt(s)>255){
                return false;
            }
        }
        return true;
    }

}

