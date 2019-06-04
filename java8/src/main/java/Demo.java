public class Demo {
    public static void main(String[] args) {
            jrEmp.ep();
    }
}

class Employee {
    static void ep(){
        System.out.println("staticclas");
    }
}

class jrEmp extends Employee{
    static void ep(){
        System.out.println("staticclas1234");
    }
}
