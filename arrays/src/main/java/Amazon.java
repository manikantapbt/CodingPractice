import java.util.*;

public class Amazon {
    public static void main(String[] args) {

        String s = "mani is good boy 10";
        String s2 = "klankta";

        int index=s.indexOf(" ");
        System.out.println(s.substring(index+1,s.length()));




        List<Integer> list= new ArrayList<>();
        list.add(1);
        list.add(2);


        list.addAll(list);
    }
}