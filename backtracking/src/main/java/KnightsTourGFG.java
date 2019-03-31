public class KnightsTourGFG {
    public static void main(String[] args) {
        int N = 9;
        int[][] arr = new int[N][N];
        arr[0][0] = 1;
        boolean result = solveKnight(arr, 0, 0, 2, N);
        System.out.println(result);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }
    }

    public static boolean solveKnight(int[][] arr, int x, int y, int count, int N) {
        if (count == (N * N)+1) {
            return true;
        }
        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};
        for (int i = 0; i < xMove.length; i++) {
            int xnext = x + xMove[i];
            int ynext = y + yMove[i];
            if (isSafe(arr,xnext, ynext, N)) {
                arr[xnext][ynext] = count;
                if (solveKnight(arr, xnext, ynext, count + 1, N)) {
                    System.out.println(count);
                    return true;
                } else {
                    arr[xnext][ynext] = 0;
                }
            }
        }
        return false;
    }

    public static boolean isSafe(int[][] arr,int x, int y, int N) {
        if (x >= 0 && x < N && y >= 0 && y < N && arr[x][y]==0) {
            return true;
        }
        return false;
    }
}
