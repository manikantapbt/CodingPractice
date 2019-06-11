public class Trail {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(12));
        System.out.println(highestPowerOfTwoLessThanNumber(12));
    }
    public static int highestPowerOfTwoLessThanNumber(int n){
        int number=0;

        while(n/2>0){
            number++;
            n=n/2;
        }
        return number;
    }
}
