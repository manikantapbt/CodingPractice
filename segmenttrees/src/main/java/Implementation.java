public class Implementation {
    public static void main(String[] args) {
        Integer[] arr = {1, 3, 5, 7, 9, 11};
        Integer newSize = nextPowerOfTwo(arr.length);
        Integer[] newArr = new Integer[newSize];
        for (int i = 0; i < newSize; i++) {
            if (i < arr.length) {
                newArr[i] = arr[i];
            } else {
                newArr[i] = 0;
            }
        }
        Node n = construct(newArr, 0, newSize - 1);
        System.out.println(n.a);
        System.out.println(rangeQuery(n,0,newSize-1,0,3));
        System.out.println(updateElement(n,0,newSize-1,1,8));
        System.out.println(rangeQuery(n,0,newSize-1,0,3));

    }

    public static Node construct(Integer[] arr, int low, int high) {
        Node node = new Node();
        int mid = (high + low) / 2;
        if (high == low) {
            node.a = arr[high];
        } else {
            Node right = construct(arr, mid + 1, high);
            Node left = construct(arr, low, mid);
            node.left=left;
            node.right=right;
            node.a = left.a + right.a;
        }
        return node;
    }

    public static int rangeQuery(Node node,int low,int high,int rangeL,int rangeHigh){
        int mid = (low+high)/2;
        if (node.left==null && node.right==null){
            return node.a;
        }
        if (high == low) {
           return node.a;
        }

        int left=0;
        int right=0;
        if(rangeL<=mid){
            left=
            rangeQuery(node.left,low,mid,rangeL,rangeHigh);
        }
        if(mid +1<=rangeHigh){
            right= rangeQuery(node.right,mid+1,high,rangeL,rangeHigh);
        }
        return left+right;
    }
    public static int updateElement(Node a,int low,int high,int index,int updateElement){
        int mid = (high+low)/2;
        if(high==low){
            int old = a.a;
            a.a=updateElement;
            return old;
        }
        if(index<=mid){
            return updateElement(a.left,low,mid,index,updateElement);
        }
        if(mid+1<=index){
            return updateElement(a.right,mid+1,high,index,updateElement);
        }
        return 0;
    }
    public static int nextPowerOfTwo(int a) {
        String s = Integer.toBinaryString(a);
        return FastExponentiation.fastExpo(2, s.length());
    }
}

class Node {
    int a;
    Node left;
    Node right;
}