import java.util.ArrayList;

public class PrintPathsToNodes {
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.left.right.left = new Node(8);
		root.left.right.left.right = new Node(9);
		int[] list = new int[20];
		printPath(root, list, 0);
		System.out.println("==================");
		ArrayList<Integer> arrayList = new ArrayList<>();
		printPathList(root, arrayList, 0);
		System.out.println("==================");
		printPathListMem(root, arrayList, 0);
	}

	public static void printPath(Node root, int[] list, int len) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			list[len] = root.key;
			printArray(list, len);
		}
		list[len] = root.key;
		printPath(root.left, list, len + 1);
		printPath(root.right, list, len + 1);

	}

	public static void printArray(int[] list, int len) {
		for (int i = 0; i <= len; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
	}

	public static void printPathList(Node root, ArrayList<Integer> list, int len) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			if (len < list.size()) {
				list.set(len, root.key);
			} else {
				list.add(root.key);
			}
			printArrayList(list, len);
		}
		if (len < list.size()) {
			list.set(len, root.key);
		} else {
			list.add(root.key);
		}
		printPathList(root.left, list, len + 1);
		printPathList(root.right, list, len + 1);

	}

	public static void printArrayList(ArrayList<Integer> list, int len) {
		for (int i = 0; i <= len; i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}
	public static void printPathListMem(Node root, ArrayList<Integer> list, int len) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			list.add(root.key);
			System.out.println(list);
		}
		list.add(root.key);
		printPathList(root.left, list, len + 1);
		printPathList(root.right, list, len + 1);
		list.remove(list.size()-1);
	}


}
