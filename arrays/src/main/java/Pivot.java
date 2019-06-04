public class Pivot {
    public static void main(String[] args) {
        int arr[] = {8, 7, 2, 5, 4, 1, 6, 9, 3};
        pivot(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[i] = " + arr[i]);
        }
    }

    public static void pivot(int arr[]) {
        int pivot = arr.length - 1;
        int low = 0;
        int high =reInitHigh(arr,pivot,arr.length-2);
        while (low<=high){
            if(arr[low]>arr[pivot]){
                swap(arr,low,high);
                high=reInitHigh(arr,pivot,high-1);
            }
            low++;
        }
        swap(arr,low,pivot);
    }
    public static int reInitHigh(int arr[],int pivot,int currentHigh){
        int i=currentHigh;
        for(;i>=0;i--){
            if(arr[i]<arr[pivot]){
                break;
            }
        }
        return i;
    }
    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
