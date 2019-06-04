import java.util.Set;

public class NQueens {
    static int count=0;
    public static void main(String[] args) {
        int N = 100;
        long start_time = System.currentTimeMillis();
        int arr[][] = new int[N][N];
        System.out.println(nQueens(arr, 0,N-1,0));
        System.out.println(System.currentTimeMillis() - start_time);
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

    public static boolean nQueens(int[][] arr, int row,int totalqueens,int totalQueensPlaced) {

        System.out.println(count++);
        if(totalqueens<totalQueensPlaced) return true;
        for (int kol = 0; kol < arr.length; kol++) {
            if (isSafe( arr,row, kol,arr.length)) {
                arr[row][kol] = 1;
                if (nQueens(arr, row + 1,totalqueens,totalQueensPlaced+1)) {
                    return true;
                } else {
                    arr[row][kol] = 0;
                }
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
        /*if(!isDiagonalSafe(row,col,arr)){
            return false;
        }*/
        //1st quad
        for (int i = row, j = col; (i < N && j < N); i++, j++) {
            if (arr[i][j] == 1)
                return false;
        }

        //2nd quad
        for (int i = row, j = col; (i >= 0 && j < N); i--, j++) {
            if (arr[i][j] == 1)
                return false;
        }

        //3rd quad
        for (int i = row, j = col;(i >= 0 && j >= 0); i--, j--) {
            if (arr[i][j] == 1)
                return false;
        }

        // 4th quad
        for (int i = row, j = col;( i < N && j >= 0); i++, j--) {
            if (arr[i][j] == 1)
                return false;
        }

        return true;
    }



    private static boolean isDiagonalSafe(int row, int column, int[][] chess) {
        int[][] diagonals = {
                { 1, 1},
                {-1, 1},
                {-1,-1},
                { 1,-1}
        };

        for(int[] diagonal: diagonals){
            int nextRow = row + diagonal[0];
            int nextCol = column + diagonal[1];

            if(nextRow < chess.length &&
                    nextRow > -1 &&
                    nextCol < chess[0].length &&
                    nextCol > -1 &&
                    chess[nextRow][nextCol] !=0)
                return false;
        }

        return true;
    }

    private static boolean isSafe(int row, int column, int[][] chess) {
        return isRowSafe(row,chess) &&
                isColumnSafe(column,chess) &&
                isDiagonalSafe(row,column,chess);
    }

    private static boolean isColumnSafe(int column, int[][] chess) {
        for (int[] rows : chess)
            if (rows[column] != 0) return false;

        return true;
    }

    private static boolean isRowSafe(int row, int[][] chess) {
        for(int value : chess[row])
            if (value != 0) return false;

        return true;
    }

}
