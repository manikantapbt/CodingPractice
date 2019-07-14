import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MAinClass {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(3);
        list.add(1);
        list.add(5);
        list.sort((a,b)->b-a);
        System.out.println(list);

    }
    public static String foo(String s){

        return s;
    }
}

