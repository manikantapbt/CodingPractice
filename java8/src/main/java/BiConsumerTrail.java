import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class BiConsumerTrail {

    public static void main(String[] args) {
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();

        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        map.put("four",4);
        map.remove("one");
        map.put("one",22);
        map.put("two",25);



        Map<String,Integer> map1 = new HashMap<>();

        map1.put("one",1);
        map1.put("two",2);
        map1.put("three",3);
        map1.put("four",4);

        for(String i:map.keySet()){
            System.out.println(map.get(i));
        }

        System.out.println("=========");

        for(String i:map1.keySet()){
            System.out.println(map1.get(i));
        }


        int x=5;
        map1.computeIfAbsent("Five",p->{
            System.out.println(p);
            return x;});

        map1.computeIfPresent("one", new BiFunction1());
        System.out.println(map1);


    }

}
class BiConsumer1 implements BiConsumer<String,Integer>{

    @Override
    public void accept(String k, Integer v) {
        v=v*2;
    }
}
class Consumer1<T> implements Consumer<T>{

    @Override
    public void accept(T t) {
        System.out.println(t);
    }
}

class BiFunction1 implements BiFunction<String,Integer,Integer>{

    @Override
    public Integer apply(String s, Integer integer) {
        return integer*33;
    }
}