interface Sayable {
    void say(int a);
}

public class MethodReference {
    public static void saySomething() {
        System.out.println("Hello, this is static method.");
    }

    public static int saySomething1(int a) {
        System.out.println("Hello, this is static method2.");
        return 1;
    }

    public static void main(String[] args) {
        Sayable say = (a)-> System.out.println(a);
        say.say(4);
        System.out.println(say.getClass());
    }
}
