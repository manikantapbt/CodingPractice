import java.util.function.Predicate;

public class Apple {
    int weight;
    String color;
    Apple(int weight){
        this.weight=weight;
    }

    public Predicate<Apple> isGreenAndHeavy(Apple a,Apple b){
        return  (apple) -> (apple.weight>50);
    }

    public static boolean isHeavy(Apple apple, Apple appleb){
        return apple.weight>50;
    }

    public int getWeight(){
        return  weight;
    }

    public String getColor(){
        return color;
    }
    public static int  compare(Apple o1, Apple o2){
        return o1.getWeight()-o2.getWeight();
    }
}

