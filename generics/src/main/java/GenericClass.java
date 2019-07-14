import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericClass<T1,T2>{

    void genericDisplay(T1 var1,T2 var2){

    }
    static <T extends List> void duplicateList(T list){
        list.addAll(list);
    }

    static void addSomeNumbers(List<? super Number> list){

    }

    public static void main(String[] args) {
        GenericClass<? super Number,String> s = new GenericClass<>();
        s.genericDisplay(Integer.valueOf(1),"");

        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        duplicateList(arrayList);
        System.out.println(arrayList);

        GenericClass<Integer,Integer> g  = new GenericClass<>();
        g.display(10,10);

        GenericClass<String,Integer> g1 =  new GenericClass<>();

        g1.display("mani",1);

        List<GenericClass> list = new ArrayList<>();
        list.add(g);
        list.add(g1);
        print(list);
    }
    public void display(T1 var1,T2 var2){
        System.out.println("var1 = " + var1);
        System.out.println("var2 = " + var2);
    }

    public static <E> void  print(List<E> list){
        for(E e:list){
            System.out.println("e = " + e);
        }
    }

}
