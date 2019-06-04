import java.util.HashMap;
import java.util.Map;

public class NullTest {
    public static void main(String[] args) {
        Emp e = new Emp1();
        new NullTest().f(e);
    }

    void f(Emp e){
        System.out.println(e.getClass().getSimpleName());
        System.out.println("123");
    }
    void f(Emp1 e){
        System.out.println("456");
    }
}
class Emp{

}
class Emp1 extends Emp{

}
