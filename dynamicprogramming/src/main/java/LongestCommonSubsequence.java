import java.util.Arrays;

public class LongestCommonSubsequence {
	public static void main(String[] args) {
		String s = "manikanta";
		String s1 = "kanta";
		int table[][] = new int[s.length()][s1.length()];
		for (int[] row : table)
			Arrays.fill(row, -1);
		 int k = LCS(s, s1, s.length() - 1, s1.length() - 1, table);
		System.out.println(k);
		System.out.println(LCSBottomUp(s, s1));
	}

	public static int LCS(String s, String s1, int index1, int index2, int[][] table) {

		if (index1 < 0 || index2 < 0)
			return 0;
		if (table[index1][index2] != -1) {
			System.out.println("using chache");
			return table[index1][index2];
		}
		if (s.charAt(index1) == s1.charAt(index2)) {
			return table[index1][index2] = 1 + LCS(s, s1, index1 - 1, index2 - 1, table);
		} else
			return table[index1][index2] = Math.max(LCS(s, s1, index1, index2 - 1, table),
					LCS(s, s1, index1 - 1, index2, table));
	}

	public static int LCSBottomUp(String s1, String s2) {
		int[][] dp = new int[s1.length()][s2.length()];
		
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				if (i == 0 && j == 0) {
					if (s1.charAt(i) == s2.charAt(j)) {
						dp[i][j] = 1;
					}
				}else if(i==0) {
					if (s1.charAt(i) == s2.charAt(j)) 
						dp[i][j]=1;
					else
					dp[i][j]=dp[i][j-1];
				}
				else if(j==0) {
					if (s1.charAt(i) == s2.charAt(j)) 
						dp[i][j]=1;
					else
					dp[i][j]=dp[i-1][j];
				}
				else {
					if (s1.charAt(i) == s2.charAt(j)) {
						dp[i][j] = 1 + dp[i - 1][j - 1];
					} else {
						dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
					}
				}
			}
		}
		return dp[s1.length() - 1][s2.length() - 1];
	}
}
