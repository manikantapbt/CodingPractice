import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

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
         empList.parallelStream().map(f2).filter(x->x.substring(4).equals("2")).forEach(System.out::print);
    }
}

class Employee123{
    Integer id;
    String name;

    public Employee123(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}