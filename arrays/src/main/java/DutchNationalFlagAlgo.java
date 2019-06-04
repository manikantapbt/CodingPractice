public class DutchNationalFlagAlgo {
    public static void main(String[] args) {
        int arr[]={1,2,2,1,0,2,2,2,1,1,1,0,0,0,0,0,2};
        dutchNationalFlagAlgo(arr);
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }

    }
    public static void dutchNationalFlagAlgo(int []arr){
        int hi=arr.length-1;
        int low=0,mid=0;

        while(mid<=hi){
            if(arr[mid]==0){
                swap(arr,mid,low);
                low++;
                mid++;

            }
            else if(arr[mid]==1){
                mid++;
            }
            else {
                swap(arr,mid,hi);
                hi--;
            }
        }
    }

    public static void swap(int[] arr,int x,int y){
        int temp = arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }

}
