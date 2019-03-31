import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class HelloSafari {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        Iterator<Integer> it = arr.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("arr = " + arr);
    }
}
