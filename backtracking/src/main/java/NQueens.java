import java.util.Set;

public class NQueens {
	public static void main(String[] args) {
		int N = 4;
		long start_time= System.currentTimeMillis();
		int arr[][] = new int[N][N];
		System.out.println(nQueens(arr, 0));
		System.out.println(System.currentTimeMillis()-start_time);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static boolean nQueens(int[][] arr, int row) {
		if (row >= arr.length) {
			return true;
		}
		for (int kol = 0; kol < arr.length; kol++) {
			if (isSafe(arr, row, kol, arr.length)) {
				arr[row][kol] = 1;
				if (!nQueens(arr, row + 1)) {
					arr[row][kol] = 0;
				}
			}
		}
		for (int kol = 0; kol < arr.length; kol++) {
			if (arr[row][kol] == 1) {
				return true;
			}
		}
		return false;
	}
	public static boolean isSafe(int arr[][], int row, int col, int N) {
		// checking in the row
		for (int i = 0; i < N; i++) {
			if (arr[row][i] == 1) {
				return false;
			}
		}
		for (int i = 0; i < N; i++) {
			if (arr[i][col] == 1) {
				return false;
			}
		}
		// upper left
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (arr[i][j] == 1)
				return false;
		}
		// upper right
		for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
			if (arr[i][j] == 1)
				return false;
		}
		// lower left
		for (int i = row, j = col; i < N && j >= 0; i++, j--) {
			if (arr[i][j] == 1)
				return false;
		}
		for (int i = row, j = col; i < N && j < N; i++, j++) {
			if (arr[i][j] == 1)
				return false;
		}
		return true;
	}
	static void mani() {
		
	}
}
