public class MaximumPathSum {
    public static int globalSum;
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(5);
        root.right.left.left = new Node(10);
        root.right.right = new Node(4);
        root.right.right.right = new Node(4);
        System.out.println(maxPathSum(root));
        maxPathSumMethod2(root,0);
        System.out.println(globalSum);
    }
    public static int maxPathSum(Node root){
        if(root==null)
            return 0;
        return root.key+Math.max(maxPathSum(root.left),maxPathSum(root.right));
    }
    public static void  maxPathSumMethod2(Node root,int sum){
        if(root==null)
            return ;
        sum=sum+root.key;
        if(sum>globalSum){
            globalSum=sum;
        }
        maxPathSumMethod2(root.left,sum);
        maxPathSumMethod2(root.right,sum);
        sum=sum-root.key;
    }
}
