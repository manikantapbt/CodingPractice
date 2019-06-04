import com.sun.media.sound.RIFFInvalidDataException;

public class HeapImplementation {

    public static void main(String[] args) {
        //int arr[] = {40,100,50,40,30,15,10};
        int arr[] = {9, 8, 7, 6, 10, 5, 4, 3, 2, 1};
        constructMinHeapBottomUp(arr);
        for (int index = 0; index < arr.length; index++) {
            System.out.println(arr[index]);
        }
    }

    public static void constructMinHeap(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int parent = parent(i);
            if (arr[i] < arr[parent]) {
                rectifyHeap(arr, i);
            }
        }
    }

    public static void rectifyHeap(int arr[], int index) {
        int parent = parent(index);
        if (index == 0) return;
        else if (arr[index] > arr[parent]) {
            return;
        } else {
            swap(arr, index, parent);
            rectifyHeap(arr, parent);
        }
    }

    public static int parent(int index) {
        return (index == 0) ? 0 : (index - 1) / 2;
    }

    public static void swap(int arr[], int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void constructMinHeapBottomUp(int arr[]) {
        int startIndex = arr.length / 2;
        for (int i = (startIndex); i >= 0; i--) {
            rectifyHeapTopDown(i, arr);
        }
    }

    public static void rectifyHeapTopDown(int i, int[] arr) {
        int leftChildIndex = leftChild(i, arr.length);
        int rightChildIndex = rightChild(i, arr.length);
        int leftChild = Integer.MIN_VALUE;
        int rightChild = Integer.MIN_VALUE;
        if (leftChildIndex != Integer.MIN_VALUE) {
            leftChild = arr[leftChildIndex];
        }
        if (rightChildIndex != Integer.MIN_VALUE) {
            rightChild = arr[rightChildIndex];
        }
        int parent = arr[i];
        int littleOne = 0;
        int littleIndex=0;
        if (leftChild == Integer.MIN_VALUE) {
            littleOne = rightChild;
            littleIndex=rightChildIndex;
        }
        if (rightChild == Integer.MIN_VALUE) {
            littleOne = leftChild;
            littleIndex=leftChildIndex;
        }
        if(leftChild!=Integer.MIN_VALUE && rightChild!=Integer.MIN_VALUE){
            littleOne=Math.min(leftChild,rightChild);
            littleIndex = (littleOne == leftChild) ? leftChildIndex : rightChildIndex;
        }
        if (parent > littleOne && littleOne != Integer.MIN_VALUE) {

            swap(arr, i, littleIndex);
            rectifyHeapTopDown(littleIndex, arr);
        }

        return;

    }

    public static int leftChild(int index, int size) {
        return (2 * index) + 1 < size ? (2 * index) + 1 : Integer.MIN_VALUE;
    }

    public static int rightChild(int index, int size) {
        return (2 * index) + 2 < size ? (2 * index) + 2 : Integer.MIN_VALUE;
    }
}
