import java.util.ArrayList;

public class CombinationSum {
    public static ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        int arr[] = {10, 1, 2, 7, 6, 1, 5};
        int sum = 8;
        System.out.println(noOfWays(0, sum, 0, arr));
        noOfWaysWithResult(0,sum,0,arr,new ArrayList<>());
        System.out.println(result);
    }

    public static int noOfWays(int index, int sum, int currentSum, int[] arr) {
        if (currentSum == sum) {
            return 1;
        }
        if (currentSum > sum || index >= arr.length) {
            return 0;
        }
        return noOfWays(index + 1, sum, currentSum, arr) +
                noOfWays(index + 1, sum, currentSum + arr[index], arr);
    }

    public static void noOfWaysWithResult(int index, int sum, int currentSum, int[] arr, ArrayList<Integer> currentArraysList) {
        if (currentSum == sum) {
            ArrayList<Integer> newList = new ArrayList<>(currentArraysList);
            result.add(newList);
            return ;
        }
        if (currentSum > sum || index >= arr.length) {
            return ;
        }
        currentArraysList.add(arr[index]);
        noOfWaysWithResult(index+1,sum,currentSum+arr[index],arr,currentArraysList);
        currentArraysList.remove(currentArraysList.size()-1);
        noOfWaysWithResult(index+1,sum,currentSum,arr,currentArraysList);
    }

}
