import java.lang.Math;
import java.util.Arrays;

public class LengthChainOfPairs {

	public static void main(String[] args) {
		Pair arr[] = new Pair[] { new Pair(5, 24), new Pair(15, 25), new Pair(27, 40), new Pair(50, 60) };
		System.out.println(returnMaxLength(arr));
	}

	private static int returnMaxLength(Pair[] arr) {
		if (arr.length == 0)
			return 0;
		if (arr.length == 1)
			return 1;
		int[] table = new int[arr.length];
		int globalmax = Integer.MIN_VALUE;
		Arrays.fill(table, 1);
		for (int i = 1; i < arr.length; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				if (arr[j].b < arr[i].a) {
					max = Math.max(max, table[j]);
				}
			}
			if (max != Integer.MIN_VALUE) {
				table[i] = max + 1;
			}
			if (globalmax < table[i]) {
				globalmax = table[i];
			}
		}
		return globalmax;
	}
}

class Pair {
	int a;
	int b;

	Pair(int a, int b) {
		this.a = a;
		this.b = b;
	}
}