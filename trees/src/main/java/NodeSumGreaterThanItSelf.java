public class NodeSumGreaterThanItSelf {
    static int sum=0;
    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(6);
        node.left.right=new Node(7);
        node.left.right.right=new Node(8);
        node.right=new Node(12);
        node.right.right=new Node(15);
        node.right.left=new Node(11);
        modifiedInorderToCalculateSum(node);
        inorder(node);
    }


    public static void modifiedInorderToCalculateSum(Node root){
        if(root.right!=null) modifiedInorderToCalculateSum(root.right);
        root.key = root.key+sum;
        sum=root.key;
        if(root.left!=null) modifiedInorderToCalculateSum(root.left);
    }

    public static void inorder(Node root){
        if (root.left != null) {
            inorder(root.left);
        }
        System.out.println(root.key);
        if (root.right != null) {
            inorder(root.right);
        }
    }
}

