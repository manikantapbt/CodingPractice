import java.io.File;
import java.io.FileFilter;
import java.io.Serializable;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;

public class MainAppleCom {
    public static void main(String[] args) {
        List<Apple> list = new ArrayList<>();
        list.add(new Apple(100));
        list.add(new Apple(10));
        list.add(new Apple(50));
        list.add(new Apple(1));
        list.add(new Apple(5));
        list.add(new Apple(60));
        list.add(new Apple(70));
        list.add(new Apple(20));
        list.get(0).color = "green";


        list.sort(comparingInt(Apple::getWeight));
        list.forEach(x -> System.out.println(x));

        System.out.println("size = " + mani(-15));
        MainAppleCom ma = new MainAppleCom();
        //Predicate<Apple> predicate = (apple)-> apple.weight >50 && apple.color.equals("green");
        //  List<Apple> applesList = ma.filterApple(list, predicate);
        //List<Apple> applesList1 = ma.filterApple(list, new Apple(1).isGreenAndHeavy());

        // System.out.println("applesList = " + applesList);


        //Map<String, Apple> map = list.stream().collect(Collectors.toMap(Apple::getColor, Arrays::asList));

        System.out.println(filterApple(list, Apple::isHeavy));

        Consumer<Apple> con = System.out::println;

        con.accept(list.get(0));

        StringBuilder sb = new StringBuilder();


    }


    public static int mani(int cap) {


        int MAXIMUM_CAPACITY = 1 << 30;
        int n = cap - 1;
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }


    public static List<Apple> filterApple(List<Apple> apple, BiPredicate<Apple, Apple> p) {
        List<Apple> applesFiltered = new ArrayList<>();
        for (Apple a : apple) if (p.test(a, a)) applesFiltered.add(a);

        return applesFiltered;
    }

    public static void ma1(MA<Apple> ma) {

    }

}

@FunctionalInterface
interface MA<T> {
    int compare(T o1, T o2);

    public static <T> Comparator<T> cmp(ToIntFunction<? super T> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return (Comparator<T> & Serializable)
                (c1, c2) -> Integer.compare(keyExtractor.applyAsInt(c1), keyExtractor.applyAsInt(c2));
    }
}
interface A{
    void a();
    int b();
}
