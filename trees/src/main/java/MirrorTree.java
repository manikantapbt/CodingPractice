public class MirrorTree {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right= new Node(5);
		root.right.left= new Node(6);
		root.left.right.left= new Node(8);
		root.left.right.left.right= new Node(9);
		inorder(root);
		System.out.println();
		System.out.println("mirror");
		mirror(root);
		inorder(root);
	}

	public static Node mirror(Node root) {
		if(root==null) return null;
		Node leftTr = mirror(root.left);
		Node rightTr = mirror(root.right);	
		root.right=leftTr;
		root.left=rightTr;
		
		return root;
	}
	public static void inorder(Node root) {
		if(root.left!=null) inorder(root.left);
		System.out.print(root.key+ " ");
		if(root.right!=null) inorder(root.right);
	}
}
