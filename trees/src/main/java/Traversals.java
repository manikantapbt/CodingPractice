import java.util.Stack;

public class Traversals {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right= new Node(5);
		root.right.left= new Node(6);
		root.left.right.left= new Node(8);
		root.left.right.left.right= new Node(9);


		printInOrder(root);
		System.out.println("==============");
		printInOrderWithoutRecursion(root);
		System.out.println("==============");
		printPreOrder(root);

	}
	public static void printPreOrder(Node root) {
		System.out.println(root.key);
		if(root.left!=null) printPreOrder(root.left);
		if(root.right!=null) printPreOrder(root.right);
	}
	public static void printInOrder(Node root) {
		if (root.left != null)
			printInOrder(root.left);
		System.out.println(root.key);
		if (root.right != null)
			printInOrder(root.right);
	}

	public static void printInOrderWithoutRecursion(Node root) {
		Stack<Node> s = new Stack();
		s.push(root);
		insertLeftTillBottom(root,s);
		while(!s.isEmpty()) {
			Node popped = s.pop();
			System.out.println(popped.key);
			if(popped.right!=null) {
				s.push(popped.right);
				insertLeftTillBottom(s.lastElement(), s);
			}
		}
	}
	public static void insertLeftTillBottom(Node node,Stack s) {
		while (node.left!= null) {
			s.push(node.left);
			node=node.left;
		}
	}
	public static void printInOrderNOStackNoRecur(Node root) {
		
	}
}
