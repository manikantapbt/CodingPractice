import java.util.Arrays;

public class PostOrderFromInorderAndPreorder {
	static int preindex = 0;
	static int preindexm2=0;
	public static void main(String[] args) {
		int[] inorder = { 4, 2, 5, 1, 3, 6 };
		int[] preorder = { 1, 2, 4, 5, 3, 6 };
		printPostOrder(inorder, preorder, 0, inorder.length - 1);
		Node root=printPostOrderM2(inorder, preorder, 0, inorder.length - 1);
		System.out.println("==============");
		postOrder(root);
	}

	public static void printPostOrder(int[] in, int[] pre, int start, int end) {
		if (start <= end) {
			int index = search(in, start, end, pre[preindex++]);
			printPostOrder(in, pre, start, index - 1);
			printPostOrder(in, pre, index + 1, end);
			System.out.println(in[index]);
		}
	}

	public static int search(int[] in, int startIn, int endIn, int data) {
		int i = 0;
		for (i = startIn; i < endIn; i++)
			if (in[i] == data)
				return i;
		return i;
	}

	public static Node printPostOrderM2(int[] in, int[] pre, int start, int end) {
		if (start > end) {
			return null;
		}
		if(start==end) {
			return new Node(in[start]);
		}
		int index = search(in, start, end, pre[preindexm2++]);
		Node node = new Node(in[index]);
		node.left = printPostOrderM2(in, pre, start, index - 1);
		node.right = printPostOrderM2(in, pre, index + 1, end);
		return node;
	}
	
	public static void postOrder(Node root) {
		if(root.left!=null) postOrder(root.left);
		if(root.right!=null) postOrder(root.right);
		System.out.println(root.key);
	}
}
