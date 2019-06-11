public class FastExponentiation {
    public static void main(String[] args) {
        System.out.println("pow = " + fastExpo(3,5));
    }
    public static long fastExpo(int num,int pow){
        if(pow==0) return 1;
        if(pow==1) return num;
        long ans = fastExpo(num,pow/2);
        ans = ans * ans;
        if(pow%2==1){
            ans = ans * num;
        }
        return ans;
    }

}

