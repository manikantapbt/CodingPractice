public class BuyAndSell {
    public static void main(String[] args) {
        int[] arr = {100, 80, 60, 70, 60, 75, 85};
        int[] stockArr = new int[arr.length];
        stockArr[0]=arr[0];
        int maxProfit=0;
        for (int i = 1; i < arr.length; i++) {
            int currProfit=0;
            stockArr[i]= Math.min(stockArr[i-1],arr[i]);
            currProfit = arr[i]-stockArr[i];
            if(currProfit>maxProfit){
                maxProfit=currProfit;
            }
        }
        System.out.println("maxProfit = " + maxProfit);
    }
}
