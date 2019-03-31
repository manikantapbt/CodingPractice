/*
 *  https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
 * */
public class MorrisInOrderTraversal {
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
	    
	    morrisInOrderTraversal(root);
	}
	
	public static Node rightMost(Node root) {
		Node prev = root;
		while(prev.right!=null && prev.right!=root ) {
			prev=prev.right;
		}
		return root;
	}
	public static void morrisInOrderTraversal(Node root) {
		Node current = root;
		while(current!=null) {
			if(current.left==null) {
				System.out.println(current.key);
				current=current.right;  // we need to make sure all null rights points to inorder successor
			}
			else {
				Node predecessor = current.left;
				
				while(predecessor.right!=null  && predecessor.right!= current) {   
					predecessor = predecessor.right;
				}
				if(predecessor.right ==null) {				
					System.out.println(current.key);
					predecessor.right = current;
					current = current.left;
				}
				else {   // predecessor is now point to current, when  flow exitted from while loop
					predecessor.right=null;
					current= current.right;
				}
			}
		}
	}
}
