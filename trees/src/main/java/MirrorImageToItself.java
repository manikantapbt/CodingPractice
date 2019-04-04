public class MirrorImageToItself {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(5);
        root.right.right = new Node(4);

        Node root2=mirror(root);
        System.out.println(identical(root,root2));
    }
    public static Node mirror(Node root1){
        if(root1==null)
            return null;
        Node mirrorNode=new Node(root1.key);
        mirrorNode.left=mirror(root1.right);
        mirrorNode.right=mirror(root1.left);
        return mirrorNode;
    }
    public static boolean identical(Node root1, Node root2){
        if(root1==null && root2 ==null)
            return true;
        if((root1==null && root2!=null)||(root2==null && root1!=null))
            return false;
        if(root1.key==root2.key){
            return identical(root1.left,root2.left)&&identical(root1.right,root2.right);
        }
        return false;
    }
}
