import java.util.ArrayList;
import java.util.Objects;

public class RefernceTest {

    public static void main(String[] args) {
        Employeesh e1 = new Employeesh("mani",1);
        Employeesh e2=null;
        try {
           e2=  (Employeesh) e1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(e1.hashCode()==e2.hashCode());
    }
}

class Employeesh implements Cloneable{
    String name;
    int id;

    public Employeesh(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "Employeesh{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
