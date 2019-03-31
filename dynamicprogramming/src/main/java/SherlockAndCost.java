import java.util.Arrays;

public class SherlockAndCost {
	public static void main(String[] args) {
		int a[] = { 3, 12, 15 };
		System.out.println(maxCost(a, a.length - 1, Integer.MIN_VALUE));
		System.out.println(maxCostDp(a));
		System.out.println(maxCostDp1(a));
	}

	public static int maxCost(int[] arr, int index, int globalmax) {
		if (index < 0)
			return globalmax;
		int[] arrOne = Arrays.copyOf(arr, arr.length);
		int[] arrTwo = Arrays.copyOf(arr, arr.length);
		arrOne[index] = 1;
		int oneCost = absoluteDiff(arrOne);
		int twoCost = absoluteDiff(arrTwo);
		globalmax = Math.max(oneCost, twoCost);
		return Math.max(Math.max(globalmax, maxCost(arrOne, index - 1, globalmax)),
				maxCost(arrTwo, index - 1, globalmax));
	}

	public static int absoluteDiff(int[] arr) {
		int diff = 0;
		for (int i = 1; i < arr.length; i++) {
			diff = diff + Math.abs(arr[i] - arr[i - 1]);
		}
		return diff;
	}

	public static int maxCostDp(int[] b) {
		int[][] dp = new int[2][b.length];
		for (int i = 1; i < b.length; i++) {
			dp[0][i]=Math.max(dp[0][i-1]+ Math.abs(1-1),dp[1][i-1]+Math.abs(b[i-1]-1));
			dp[1][i]=Math.max(dp[0][i-1]+Math.abs(b[i]-1),dp[1][i]+Math.abs(b[i]-b[i-1]));		
		}
		return Math.max(dp[0][b.length - 1], dp[1][b.length - 1]);
	}

	public static int maxCostDp1(int[] b) {
		int N = b.length;
		int[][] dp = new int[2][N];
		for (int j = 1; j < N; j++) {
			dp[0][j] = Math.max(dp[0][j - 1] + Math.abs(b[j] - b[j - 1]), dp[1][j - 1] + Math.abs(b[j] - 1));
			dp[1][j] = Math.max(dp[0][j - 1] + Math.abs(b[j - 1] - 1), dp[1][j - 1] + Math.abs(1 - 1));
		}
		return Math.max(dp[0][b.length - 1], dp[1][b.length - 1]);
	}
}
