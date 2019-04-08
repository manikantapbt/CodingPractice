public class NumberOfPaths {
    static int noOfRows = 5;
    static int noOfColumns = 5;
    static int noOfWays = 0;

    public static void main(String[] args) {
        countNoOfWays(0, 0);
        System.out.println(noOfWays);
        System.out.println(countNoOfWays1(0,0));
    }

    public static void countNoOfWays(int row, int col) {
        if (row == noOfRows - 1 && col == noOfColumns - 1) {
            noOfWays++;
        }
        if (row >= noOfRows || col >= noOfColumns) {
            return;
        }
        countNoOfWays(row + 1, col);
        countNoOfWays(row, col + 1);
    }

    public static int countNoOfWays1(int row, int col) {

        if (row == noOfRows - 1 && col == noOfColumns - 1) {
            return 1;
        }
        if (row >= noOfRows || col >= noOfColumns) {
            return 0;
        }
        return countNoOfWays1(row + 1, col) +
                countNoOfWays1(row, col + 1);
    }
}
