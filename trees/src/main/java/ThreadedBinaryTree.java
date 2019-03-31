import java.util.Stack;

public class ThreadedBinaryTree {
/*
 * https://www.geeksforgeeks.org/threaded-binary-tree/
 * https://www.geeksforgeeks.org/convert-binary-tree-threaded-binary-tree-set-2-efficient/
 * 
 * */
	public static void main(String[] args) {
		NodeThreaded root = new NodeThreaded(1);
		root.left = new NodeThreaded(2);
		root.right = new NodeThreaded(3);
		root.left.left = new NodeThreaded(4);
		root.left.right = new NodeThreaded(5);
		root.right.left = new NodeThreaded(6);
		root.right.right = new NodeThreaded(7);
		createThreadedBinaryTree(root);
		System.out.println("Threaded Binary Tree Verification");
		System.out.println(root.left.right.right.key);
		System.out.println(root.left.left.right.key);
	}

	public static void createThreadedBinaryTree(NodeThreaded root) {
		Stack<NodeThreaded> s = new Stack();
		s.push(root);
		insertLeftTillBottom(root, s);
		while (!s.isEmpty()) {
			NodeThreaded popped = s.pop();
			System.out.println(popped.key);
			if (popped.right != null) {
				s.push(popped.right);
				insertLeftTillBottom(s.lastElement(), s);
			} else {
				if(!s.isEmpty())
				popped.right = s.lastElement();
			}
		}
	}

	public static void insertLeftTillBottom(NodeThreaded node, Stack s) {
		while (node.left != null) {
			s.push(node.left);
			node = node.left;
		}
	}
}
