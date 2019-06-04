

public class NQueenProblem {

    public static void main(String[] args) {
        int [][] chess = new int[1500][1500];

        if(placeNQueens(chess, 0, chess.length - 1, 0))
            printBoard(chess);
        else System.out.println("Cannot Place N Queens");
    }

    private static void printBoard(int[][] chess) {
        for(int[] rows: chess){
            for (int value: rows){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    private static boolean placeNQueens(int[][] chess, int column, int totalQueens, int totalQueensPlaced) {

        if(totalQueens < totalQueensPlaced) return true;

        for(int i=0; i < chess.length; i++){
            if(isSafe(i, column, chess)){
                chess[i][column] = 1;
                if(placeNQueens(chess, column+1, totalQueens, totalQueensPlaced + 1))
                    return true;
                else
                    chess[i][column] = 0;
            }
        }

        return false;
    }

    private static boolean isSafe(int row, int column, int[][] chess) {
        return isRowSafe(row,chess) &&
                isColumnSafe(column,chess) &&
                isDiagonalSafe(row,column,chess);
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
