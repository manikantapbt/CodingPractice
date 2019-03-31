public class CoinChangeGeeksForGeeks {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		int sum = 15;
		System.out.println(no_of_OutComes_Right(arr,arr.length-1, sum));
		System.out.println(noOfOutComesByTableFilling(arr,arr.length, sum));
	}

	public static int no_of_OutComes(int[] arr, int sum) {
		if (sum < 0)
			return 0;
		if (sum == 0)
			return 1;
		else {
			int no_of_OutComes = Integer.MAX_VALUE;
			for (int i = 0; i < arr.length; i++) {
				no_of_OutComes = Math.min(no_of_OutComes, no_of_OutComes(arr, sum - arr[i]));
			}
			return no_of_OutComes + 1;

		}
	}

	public static int no_of_OutComes_Right(int[] arr, int index, int sum) {
		if (sum == 0)
			return 1;
		if (sum < 0 || index < 0)
			return 0;
		else {
			return no_of_OutComes_Right(arr, index - 1, sum) + no_of_OutComes_Right(arr, index, sum - arr[index]);
		}
	}

	public static int noOfOutComesByTableFilling(int[] S, int size,int sum) { 
		int i, j, x, y; 
		int table[][] = new int[sum + 1][size]; 
		for (i = 0; i < size; i++) 
			table[0][i] = 1; 
		for (i = 1; i < sum + 1; i++) 
		{ 
			for (j = 0; j < size; j++) 
			{ 
				x = (i-S[j] >= 0) ? table[i - S[j]][j] : 0; 
				y = (j >= 1) ? table[i][j - 1] : 0; 
				table[i][j] = x + y; 
			} 
		} 
		return table[sum][size - 1]; 
	}
	public static  int coinChangeG(int[] s,int index,int sum){

		if(sum==0) ;

		return  1;
	}
}
