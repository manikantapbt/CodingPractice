public class RatInAMaze {
    public static void main(String[] args) {
        int arr[][] = {{0, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 0, 1, 0},
                {0, 0, 1, 0}
        };
        arr[0][0]=2;
        boolean result = solveRatInMaze(arr, 0, 0, arr.length);
        if (result) {
            for (int i = 0; i <arr.length ; i++) {
                for (int j = 0; j <arr.length ; j++) {
                    System.out.print(arr[i][j]);
                    System.out.print("\t");
                }
                System.out.println();
            }
        } else {
            System.out.println("No path found");
        }
    }

    public static boolean solveRatInMaze(int arr[][], int x, int y, int lenth) {
        if (x == lenth - 1 && y == lenth - 1) {
            arr[x][y] = 2;
            return true;
        }
        int[] xMove = {0, 1,1};
        int[] yMove = {1, 0,1};
        for (int i = 0; i < xMove.length; i++) {
            int xNext = x + xMove[i];
            int yNext = y + yMove[i];
            if (isSafe(arr, xNext, yNext)) {
                arr[xNext][yNext] = 2;
                if (solveRatInMaze(arr, xNext, yNext, lenth)) {
                    return true;
                }
                arr[xNext][yNext] = 0;
            }
        }
        return false;
    }

    public static boolean isSafe(int[][] arr, int x, int y) {
        if ( x<arr.length && y<arr.length && arr[x][y] == 0 ) {
            return true;
        }
        return false;
    }
}
