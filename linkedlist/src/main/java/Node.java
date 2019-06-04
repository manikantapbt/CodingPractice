
import java.util.Scanner;

class Node {
	int data;
	Node next;

	Node() {
	}

	Node(int d) {
		data = d;
		next = null;
	}
}

class Add_LinkedList {
	Node head;

	void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		// System.out.println("");
	}

	public void push(int new_data) {
		/*
		 * 1 & 2: Allocate the Node & Put in the data
		 */
		Node new_node = new Node(new_data);

		/* 3. Make next of new Node as head */
		new_node.next = head;

		/* 4. Move the head to point to new Node */
		head = new_node;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T > 0) {
			int n1 = sc.nextInt();
			Add_LinkedList list1 = new Add_LinkedList();
			for (int i = 1; i <= n1; i++) {
				int a = sc.nextInt();
				list1.push(a);
			}
			int n2 = sc.nextInt();
			Add_LinkedList list2 = new Add_LinkedList();
			for (int i = 0; i < n2; i++) {
				int b = sc.nextInt();
				list2.push(b);
			}
			Add_LinkedList list3 = new Add_LinkedList();
			GfG g = new GfG();
			Node rs = g.addTwoLists(list1.head, list2.head);
			list3.printList(rs);
			System.out.println();
			T--;
		}
	}
}

/*
 * Please note that it's Function problem i.e. you need to write your solution
 * in the form of Function(s) only. Driver Code to call/invoke your function is
 * mentioned above.
 */

/*
 * The Node is defined as class Node { int data; Node next; Node(int d) {data =
 * d; next = null; } Node(){} }
 */
class GfG {
	Node end;

	Node addTwoLists(Node first, Node second) {
		int len1 = sizeOfLinkedList(first);
		int len2 = sizeOfLinkedList(second);
		if (len1 == 0)
			return second;
		if (len2 == 0)
			return first;

		int diff = len1 - len2;
		if (diff < 0) {
			Node temp = first;
			first = second;
			second = temp;
		}
		diff = Math.abs(diff);

		while (diff > 0) {
			Node nodeSec = new Node();
			nodeSec.data = 0;
			nodeSec.next = second;
			second = nodeSec; 	
		}

		Node sumNode = new Node();
		int carry = addTwoLinkedLists(first, second, sumNode);
		if (carry == 0) {
			return sumNode;
		} else {
			Node nodeFinal = new Node();
			nodeFinal.data = carry;
			nodeFinal.next = sumNode;
			return nodeFinal;
		}
		// Your code here
	}

	int addTwoLinkedLists(Node first, Node second, Node sumNode) {
		if (first == null) {
			sumNode = null;
			return 0;
		}
		Node node = new Node();
		Node sumNodeToNext = new Node();
		int dataTot = first.data + second.data + addTwoLinkedLists(first.next, second.next, sumNodeToNext);
		int data = dataTot % 10;
		int carry = dataTot / 10;
		sumNode.data = data;
		sumNode.next = sumNodeToNext;
		return carry;
	}

	int sizeOfLinkedList(Node node) {
		if (node == null) {
			return 0;
		}
		int size = 0;
		while (node != null) {
			node = node.next;
			size++;
		}
		return size;
	}
}