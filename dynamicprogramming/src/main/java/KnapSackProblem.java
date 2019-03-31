public class KnapSackProblem {
    public static void main(String[] args) {
        int val[] = new int[]{15, 10, 9, 5};
        int wt[] = new int[]{1, 5, 3, 4};
        int W = 8;
        int n = val.length;
        int table[][] = new int[wt.length + 1][W + 1];
        System.out.println(knapSack(val, wt, W, 0, n - 1));
        System.out.println(knapSackTopDown(val, wt, W, 0, n - 1, table));
        System.out.println(knapSackBottomUp(val, wt, W));
        System.out.println(knapSackG(val, wt, 0, W, val.length - 1));
        System.out.println(knapSackOwn(val,wt,W));
    }

    public static int knapSack(int[] val, int[] wt, int weight, int sum, int index) {
        if (weight == 0)
            return sum;
        if (weight < 0)
            return 0;
        if (index == 0)
            return val[0] + sum;
        if (index < 0)
            return 0;
        return Math.max(knapSack(val, wt, weight - wt[index], sum + val[index], index - 1),
                knapSack(val, wt, weight, sum, index - 1));
    }

    public static int knapSackTopDown(int[] val, int[] wt, int weight, int sum, int index, int[][] table) {

        if (weight == 0)
            return sum;
        if (weight < 0)
            return 0;
        if (index == 0)
            return val[0] + sum;
        if (index < 0)
            return 0;
        if (table[index][weight] != 0) {
            System.out.println("using cache");
            return table[index][weight];
        }
        table[index][weight] = Math.max(
                knapSackTopDown(val, wt, weight - wt[index], sum + val[index], index - 1, table),
                knapSackTopDown(val, wt, weight, sum, index - 1, table));
        return table[index][weight];
    }

    public static int knapSackBottomUp(int[] val, int[] weightArray, int w) {
        int dp[][] = new int[weightArray.length][w + 1];
        for (int i = 0; i < weightArray.length; i++) {
            for (int j = 0; j < w + 1; j++) {
                if (i == 0) {
                    if (weightArray[i] <= j) {
                        dp[i][j] = val[i];
                    }
                } else {
                    int s1 = 0;
                    if (weightArray[i] < j) {
                        s1 = dp[i - 1][j - weightArray[i]] + val[i];
                    }
                    int s2 = dp[i - 1][j];
                    dp[i][j] = Math.max(s1, s2);
                }
            }
        }
        return dp[val.length - 1][w];
    }

    public static int knapSackG(int[] val, int[] w, int sum, int weightLeft, int index) {
        if (weightLeft == 0) return sum;
        if (index < 0) return 0;
        return Math.max(knapSackG(val, w, sum + val[index], weightLeft - w[index], index - 1), knapSackG(val, w, sum, weightLeft, index - 1));
    }

    public static int knapSackOwn(int val[], int wt[], int w) {
        int[][] table = new int[wt.length + 1][w + 1];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if (i == 0 || j == 0) {
                    table[i][j] = 0;
                }
                else if(j>=wt[i]){
                    table[i][j]=Math.max(table[i-1][j],table[i-1][j-wt[i]]+val[i]);
                }
                else{
                    table[i][j]=table[i-1][j];
                }
            }
        }

        return table[wt.length][w];
    }
}
