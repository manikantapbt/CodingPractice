import java.io.FileNotFoundException;
import java.io.IOException;

public class NlevelInheritance extends Parent{
    public static void main(String[] args) throws IOException,InterruptedException{
        NlevelInheritance nlevelInheritance = new NlevelInheritance();
        System.out.println(nlevelInheritance.a);
        nlevelInheritance.staticMethod();
        Parent parent = new NlevelInheritance();
        parent.gp();
        parent.staticMethod();
    }

    static void  staticMethod(){
        System.out.println("staticMethod NlevelInheritance ");
    }

    void gp(){
        System.out.println("NlevelInheritance");
    }
}

 class Parent extends GrandParent{
    int a=1;
    @Override
    void gp() throws InterruptedException  {
        System.out.println("Parent");
    }
    static void  staticMethod(){
        System.out.println("staticMethod in parent");
     }
}
class GrandParent{
    int a=5;
    void gp() throws Exception,InterruptedException{
        System.out.println("GP");
    }
}
