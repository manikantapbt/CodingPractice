import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class ZigZag {
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.left.right = new Node(10);
		root.left.right.left = new Node(8);
		root.left.right.left.right = new Node(9);
		zigZag(root);
		System.out.println();
	}

	public static void zigZag(Node root) {
		Deque<Node> q = new ArrayDeque<Node>();
		q.add(root);
		int step=0;
		while (!q.isEmpty()) {
			ArrayList<Node> array = new ArrayList<>();
			for (Node node : q) {
			 array.add(node);
			}
			print(array,step);
			q.clear();
			for(Node n:array) {
				if(n.left!=null)q.add(n.left);
				if(n.right!=null)q.add(n.right);
			}
			step++;
		}
	}
	
	public static void print(ArrayList<Node> array,int step) {
		if(step%2==0) {
			for(int i =0;i<array.size();i++) {
				System.out.print(array.get(i).key+"\t");
			}
		}
		else
		{
			for(int i=array.size()-1;i>=0;i--) {
				System.out.print(array.get(i).key+"\t");
			}
		}
		System.out.println();
	}
}
