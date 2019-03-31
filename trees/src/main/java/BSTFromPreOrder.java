public class BSTFromPreOrder {

	public static void main(String[] args) {
		int[] preorder = { 10, 5, 1, 7,6,8, 40, 50 };
		Node root = constructBST(preorder, 0, preorder.length - 1);
		root.inOrder(root);
		System.out.println("=======");
		//preOrderWithoutTree(preorder, 0, preorder.length - 1);
		root.postOrder(root);
	}

	public static Node constructBST(int[] pre, int start, int end) {
		if (start > end)
			return null;
		if (start == end)
			return new Node(pre[start]);
		Node node = new Node(pre[start]);
		int index = returnIndexWhereTrendChanges(pre, start, end, pre[start]);
		node.left = constructBST(pre, start + 1, index);
		node.right = constructBST(pre, index + 1, end);
		return node;
	}

	public static int returnIndexWhereTrendChanges(int[] a, int start, int end, int data) {
		int i = start;
		for (; i < end - 1; i++) {
			if (a[i] < data && data < a[i + 1]) {
				return i;
			}
		}
		return i;
	}

	public static void preOrderWithoutTree(int[] pre, int start, int end) {
		if (start > end)
			return;
		if (start == end)
			System.out.println(pre[start]);
		// Node node = new Node(pre[start]);
		int index = returnIndexWhereTrendChanges(pre, start, end, pre[start]);
		constructBST(pre, start + 1, index);
		constructBST(pre, index + 1, end);
	}
}
