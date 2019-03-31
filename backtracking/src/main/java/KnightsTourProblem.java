import java.util.ArrayList;
import java.util.List;

public class KnightsTourProblem {
	public static void main(String[] args) {
		int N = 8;
		int arr[][] = new int[N][N];
		int count = 1;
		arr[0][0] = 1;
		boolean result = knightsTourProblem(arr, 0, 0, N, count);
		if (result) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j]);
					System.out.print("\t");
				}
				System.out.println();
			}
		} else {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j]);
					System.out.print("\t");
				}
				System.out.println();
			}
		}
		System.out.println(result);
	}

	public static boolean knightsTourProblem(int[][] arr, int x, int y, int N, int count) {
		if (count == (N * N) - 1) {
			return true;
		}
		List<Pair> safePosList = returnPossiblePair(arr, x, y, N);
		if (safePosList.isEmpty()) {
			return false;
		}
		for (Pair p : safePosList) {
			if(isSafe(p,arr)) {
				int x1 = p.n;
				int y1 = p.o;
				arr[x1][y1] = count;
				if (knightsTourProblem(arr, x1, y1, N, count + 1)) {
					return true;
				} else {
					arr[x1][y1] = 0;
				}
			}
		}
		return false;
	}

	public static boolean isSafe(int arr[][], int row, int col) {

		return false;
	}
    public static boolean isSafe(Pair p,int[][] arr){
		if(arr[p.n][p.o]==0){
			return  true;
		}
		return  false;
	}
	public static List<Pair> returnPossiblePair(int arr[][], int x, int y, int N) {
		List<Pair> pair = new ArrayList<>();
		System.out.println("Executing x=" + x + " y=" + y);
		if (x + 1 < N && y - 2 >= 0 ) {
			pair.add(new Pair(x + 1, y - 2));
		}
		if (x + 1 < N && y + 2 < N ) {
			pair.add(new Pair(x + 1, y + 2));
		}

		if (x - 1 >= 0 && y + 2 < N ) {
			pair.add(new Pair(x - 1, y + 2));
		}
		if (x - 1 >= 0 && y - 2 >= 0 ) {
			pair.add(new Pair(x - 1, y - 2));
		}

		if (x + 2 < N && y + 1 < N ) {
			pair.add(new Pair(x + 2, y + 1));
		}
		if (x + 2 < N && y - 1 >= 0 ) {
			pair.add(new Pair(x + 2, y - 1));
		}
		if (x - 2 >= 0 && y + 1 < N ) {
			pair.add(new Pair(x - 2, y + 1));
		}
		if (x - 2 >= 0 && y - 1 >= 0) {
			pair.add(new Pair(x - 2, y - 1));
		}
		return pair;
	}
}

class Pair {
	int n;
	int o;

	Pair(int n, int o) {
		this.n = n;
		this.o = o;
	}
}