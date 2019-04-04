public class DiameterOfBinaryTree {
    public static int globalDepth;
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        root.left.left=new Node(4);
        root.left.left.left=new Node(5);
        root.left.left.left.left= new Node(6);
        root.left.right=new Node(7);
        root.left.right.left=new Node(10);
        root.left.right.left.left=new Node(11);
        root.left.right.left.left.right=new Node(12);
        root.left.right.right=new Node(8);
        root.left.right.right.right=new Node(9);
        inOrder(root);
        System.out.println(globalDepth);
    }
    public static void inOrder(Node root){
        if(root==null) return;;
        inOrder(root.left);
        depthOfLeftAndRightSubTree(root);
        inOrder(root.right);
    }
    public static int depthOfLeftAndRightSubTree(Node root){
        if(root==null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right= maxDepth(root.right);
        int depth=left+right+1;
        if(depth>globalDepth){
            globalDepth=depth;
        }
        return depth;
    }
    public static int maxDepth(Node root){
        if(root==null)
            return 0;
        else return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
