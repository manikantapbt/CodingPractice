public class TestClass {

    private int x;

    public class InnerClass{
        final InnerStaticClass staticClass = new InnerStaticClass();

        private final int h =100;

        public void foo(){
            staticClass.setA("abcd");


        }

        int b = x;
    }

    public static class InnerStaticClass{
        private String a = new String("abc");

        public void setA(String a) {
            this.a = a;
        }

        public String getA() {
            return a;
        }
    }
}
