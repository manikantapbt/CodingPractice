import java.util.ArrayList;
import java.util.List;

public class TetrahedronNoOfWays {
    static int cacheUsed=0;
    public static void main(String[] args) {
        int no_of_steps= 14;
        int init_Step= 1;
        int endStep=1;
        int[][]dpStates=new int[no_of_steps+1][100];
        System.out.println(no_of_ways(no_of_steps,init_Step,endStep,dpStates));
        System.out.println("cacheUsed = " + cacheUsed);
    }
    public static int no_of_ways(int remainingSteps,int startSt,int endStep,int[][] dp){
        if(dp[remainingSteps][startSt]!=0){
            cacheUsed++;
            return dp[remainingSteps][startSt];
        }
        if( remainingSteps==0){
            if(startSt==endStep){
                return 1;
            }
            else{
                return 0;
            }
        }
        List<Integer> nextStep= returnOtherThanItself(startSt);
        int sum=0;
//        for(int i=1;i<=4;i++){
//            if(i==startSt) continue;
//            else{
//            }
//        }
        for (Integer i:nextStep){
            sum=sum+no_of_ways(remainingSteps-1,i,endStep,dp);

        }
        dp[remainingSteps][startSt]=sum;
        return  sum;
    }

    public static ArrayList<Integer> returnOtherThanItself(int a){
        int defaultArr[]={1,2,3,4};
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0;i<defaultArr.length;i++){
            if(defaultArr[i]!=a){
                al.add(defaultArr[i]);
            }
        }
        return al;
    }
}
