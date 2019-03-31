import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class ModuloOperation {

	public static void main(String[] args) {
		FastReader scanner = new FastReader();
		int total_test_cases = scanner.nextInt();
		long[] cache = new long[total_test_cases + 1];
		for (int i = 0; i < total_test_cases; i++) {
			int n = scanner.nextInt();
			cache[n] = result(1, 1000000007, n, cache);
			System.out.println(cache[n]);
		}
	}

	public static long result(int curr, int mod, int n, long[] cache) {
		if (n >= mod)
			return 0;
		if (n == 1 || n == 0)
			return 1;
		long result = (cache[n - 1] * n) % mod;
		return result;
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

}
