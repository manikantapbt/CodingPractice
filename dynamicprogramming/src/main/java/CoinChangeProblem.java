public class CoinChangeProblem {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 ,4,5,6,7,8,9,10};
		int sum = 150;
		int[][] table = new int[arr.length][sum+1];
		System.out.println(no_of_OutComes_Right(arr,arr.length-1, sum,table));
		System.out.println(no_of_OutComes_Faster(arr,sum,arr.length-1));

		//System.out.println(noOfOutComesByTableFilling(arr, sum,table));
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

	public static int no_of_OutComes_Right(int[] arr, int index, int sum,int[][] table) {

		if (sum == 0)
			return 1;
		if (sum < 0 || index < 0)
			return 0;
		if(table[index][sum]!=0)
			return table[index][sum];
		else {
			table[index][sum]=no_of_OutComes_Right(arr, index - 1, sum,table) + no_of_OutComes_Right(arr, index, sum - arr[index],table);
			return table[index][sum];
		}
	}
	public static int no_of_OutComes_Faster(int[] a,int sum,int index){
		if(index==-1) return 0;
		if(sum<0) return 0;
		if(sum==0) return 1;
		else return no_of_OutComes_Faster(a,sum-a[index],index)+no_of_OutComes_Faster(a,sum,index-1);

	}

	public static int noOfOutComesByTableFilling(int[] arr, int sum,int[][] table) {
		//int[][] table = new int[arr.length][sum+1];
		table[0][0]=1;
		for(int i=0;i<sum+1;i++) {
			table[0][i]=1;
		}
		for(int i=0;i<arr.length;i++) {
			table[i][0]=1;
		}
		for(int i=1;i<arr.length;i++) {
			for(int j=1;j<sum;j++) {
				int add = j-arr[i]>0 ? table[i][j-arr[i]] :0;
				System.out.println(i+":"+j+"="+(i-1)+":"+j+","+i+":"+(j-arr[i]));
				table[i][j]=table[i-1][j]+add;
			}
		}
		return table[arr.length-1][sum];
	}
	
	
}
