public class Subarraywithgivensum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 7, 5};
        int sum = 14;
        findRange(arr, sum);
    }

    public static void findRange(int arr[], int sum) {

        int curr_sum = arr[0];
        int start = 0, i;
        boolean bp = false;
        for (i = 1; i < arr.length; i++) {
            curr_sum = curr_sum + arr[i];
            while (curr_sum > sum && start <= arr.length - 1) {
                curr_sum = curr_sum - arr[start];
                start = start + 1;
            }
            if (curr_sum == sum)
            {
                bp = true;
                break;
            }
        }
        if (bp)
            System.out.println(start + " " + i);
        else
            System.out.println("No subarray found");

    }
}
