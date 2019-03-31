public class MorrisPreOrderTraversal {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(6);
		root.left.right.right = new Node(8);
		root.left.right.right.left = new Node(9);
		root.left.right.right.left.right = new Node(10);
	}

	public static void morrisPreOrder(Node root) {
		Node current = root;
		while (current != null) {
			if (current.left == null) {
				System.out.println(current.key);
				current = current.right;
			} else {
				Node predecessor = current.left;
				while (predecessor.right != null && predecessor.right != current) {
					predecessor = predecessor.right;
				}
				if(predecessor.right==current) {
					predecessor.right = current;
				}
			}
		}
	}
}
