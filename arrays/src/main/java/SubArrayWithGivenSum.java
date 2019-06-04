public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 7, 5};
        int sum = 3;
        int startIndex = 0;
        int endIndex = 0;
        boolean breakP = false;
        int curSum=0;
        for (int i = 0; i <arr.length ; i++) {
            if(curSum>sum){
                breakP=true;
                break;
            }
            else if(curSum<sum){
                curSum+=arr[i];
                endIndex=i;
            }
            else {
                curSum-=arr[startIndex];
                startIndex++;
            }


        }
        if(breakP){
            System.out.println("startIndex, endIndex= " + (startIndex+1)+" "+endIndex);
        }
        else {
            System.out.println("No Subarray");
        }
    }
}
