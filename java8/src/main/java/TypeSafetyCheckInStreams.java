import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TypeSafetyCheckInStreams {
    public static void main(String[] args) {
        List<Employee123> empList = Arrays.asList(
                new Employee123(1,"mani1"),
                new Employee123(2,"mani2"),
                new Employee123(3,"mani3"),
                new Employee123(4,"mani4"),
                new Employee123(5,"mani5")
        );
        String s1 = "mani1";
        int a=10;
        System.out.println("s.substring(4) = " + s1.substring(4));
        Function<Employee123,String> f2 = (Employee123 o)-> {
            Employee123 e8 = (Employee123)o;
            return e8.name;
        };
         empList.parallelStream().map(f2).filter(x->x.substring(4).equals("2")).forEach(System.out::println);

         List<Integer> list = Stream.of(1,2,4,5).collect(Collectors.toList());

        Integer inte = list.stream().peek(i-> System.out.println("Integer = " + i)).
                 peek((Number n)-> System.out.println("doubleValue = " + n.doubleValue())).max(Integer::compareTo).orElse(Integer.MAX_VALUE);
        System.out.println(inte);
    }
}

class Employee123{
    @Override
    public String toString() {
        return "Employee123{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    Integer id;
    String name;

    public Employee123(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}