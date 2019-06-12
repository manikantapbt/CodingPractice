import java.net.Inet4Address;
import java.util.ArrayList;

public class Trail {
    public static void main(String[] args) {
//        String[] arr;
//        arr = new String[2];
//        arr[1]= new String("mani");
//
//        NodeSeg n = new NodeSeg();
//        n.a=arr[1];
//
//        arr[1]= new String("manikanta");
//
//        System.out.println(n.a+" "+arr[1]);



        String[] arr = new String[3];
        arr[0] = new String("mani0");
        arr[1] = new String("mani1");
        arr[2] = new String("mani2");

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add( new String("mani0"));
        arrayList.add( new String("mani1"));
        arrayList.add( new String("mani2"));

        for (int i = 0; i < arrayList.size(); i++) {
            String s =arrayList.set(i,"kanta");
            System.out.println(s);
        }
        System.out.println(arrayList);
        }


    public static int highestPowerOfTwoLessThanNumber(int n){
        int number=0;
        while(n/2>0){
            number++;
            n=n/2;
        }
        return number;
    }
}
class NodeSeg{
    String a;
    NodeSeg left;
    NodeSeg right;
}
