public class SumOfSubsets {

	public static void main(String[] args) {
		int arr[] = { 2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2};
		int sum = 8;
		int table[][] = new int[sum + 1][arr.length];
		long start1 = System.nanoTime();
		System.out.println(noOfSubsets(arr, sum, arr.length - 1, table));
		System.out.println("end by dp:"+(System.nanoTime()-start1));

		long start2 = System.nanoTime();
		System.out.println(noOfSubsets1(arr, sum, arr.length - 1));
		System.out.println("end by recur:"+(System.nanoTime()-start2));

	}

	public static int noOfSubsets(int[] arr, int sum, int index, int[][] table) {
		if (sum == 0)
			return 1;
		if (index < 0)
			return 0;
		if (table[sum][index] != 0) {
			return table[sum][index];
		} else
			table[sum][index] = noOfSubsets(arr, sum - arr[index], index - 1, table)
					+ noOfSubsets(arr, sum, index - 1, table);
		return table[sum][index];
	}

	public static int noOfSubsets1(int[] arr, int sum, int index) {
		if (sum == 0)
			return 1;
		if (index < 0)
			return 0;
	  else
		return noOfSubsets1(arr, sum - arr[index], index - 1)
					+ noOfSubsets1(arr, sum, index - 1);
	
	}
}
