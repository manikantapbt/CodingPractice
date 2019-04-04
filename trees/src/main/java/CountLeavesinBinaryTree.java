public class CountLeavesinBinaryTree {
    public static int no_of_Leaves;

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        root.left.left = new Node(4);
        root.left.left.left = new Node(5);
        root.left.left.left.left = new Node(6);
        root.left.right = new Node(7);
        root.left.right.left = new Node(10);
        root.left.right.left.left = new Node(11);
        root.left.right.left.left.right = new Node(12);
        root.left.right.right = new Node(8);
        root.left.right.right.right = new Node(9);
        no_of_Leave(root);
        System.out.println(no_of_Leaves);
        System.out.println(getNo_of_LeavesG4G(root));
    }

    public static void no_of_Leave(Node root) {
        if (root.left != null) no_of_Leave(root.left);
        if (root.left == null && root.right == null)
            no_of_Leaves = no_of_Leaves + 1;
        if (root.right != null) no_of_Leave(root.right);
    }

    public static int getNo_of_LeavesG4G(Node root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getNo_of_LeavesG4G(root.left)+getNo_of_LeavesG4G(root.right);
    }
}
