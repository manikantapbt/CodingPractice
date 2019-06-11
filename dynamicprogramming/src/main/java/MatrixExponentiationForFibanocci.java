import java.util.List;

public class MatrixExponentiationForFibanocci {

    public static void main(String[] args) {
        System.out.println(NthFiba(4));
    }
    public static int NthFiba(int n){

        int powOfTwo= highestPowerOfTwoLessThanNumber(n);
        int[][][] cache= new int[powOfTwo+1][2][2];
        int[][] f0 = {{1,1},{1,0}};
        cache[0]=f0;
        for(int i=1;i<cache.length;i++){
            cache[i]=multiplyTwoMatrices(cache[i-1],cache[i-1]);
        }
        String s = Integer.toBinaryString(n);
        int[][] result={{1,0},{0,1}};
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                result=multiplyTwoMatrices(result,cache[s.length()-1-i]);
            }
        }
        return result[0][1];
    }
    public static int highestPowerOfTwoLessThanNumber(int n){
        int number=0;

        while(n/2>0){
            number++;
            n=n/2;
        }
        return number;
    }

    public static int[][] multiplyTwoMatrices(int[][] a,int[][] b){
        int[][] result = new int[2][2];
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                int resk=0;
                for(int k=0;k<2;k++){
                  resk=resk+ (a[i][k]*b[k][j]);
                }
                result[i][j]=resk;
            }
        }
        return result;
    }
}
