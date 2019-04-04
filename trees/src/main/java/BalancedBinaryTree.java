public class BalancedBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(7);
        //root.right.right.right.right = new Node(7);
        System.out.println(isTreeBalanced(root));

    }

    public static boolean isTreeBalanced(Node root) {
        if (root == null)
            return true;
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) >= 2) {
            return false;
        }
        return isTreeBalanced(root.right) && isTreeBalanced(root.left);

    }

    public static int height(Node root) {
        if (root == null)
            return 0;
        return 1 + Math.max(height(root.right), height(root.left));
    }
}
