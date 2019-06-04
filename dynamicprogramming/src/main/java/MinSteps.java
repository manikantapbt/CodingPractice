
public class MinSteps {
    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(minSteps(arr, 0, 0));
    }

    public static int minSteps(int[] arr, int index, int steps) {
        if (index >= arr.length - 1) {
            return steps;
        }
        if (arr[index] == 0)
            return Integer.MAX_VALUE;
        else {
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= arr[index]; i++) {
                min = Math.min(min, minSteps(arr, index + i, steps + 1));
            }
            return min;
        }

    }
}
