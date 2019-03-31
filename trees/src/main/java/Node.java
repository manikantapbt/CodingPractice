public class Node {

	int key; 
    Node left, right; 
  
    public Node(int item) 
    { 
        key = item; 
        left = right = null; 
    } 
    
	public  void postOrder(Node root) {
		if(root.left!=null) postOrder(root.left);
		if(root.right!=null) postOrder(root.right);
		System.out.println(root.key);
	}
	public  void preOrder(Node root) {
		System.out.println(root.key);
		if(root.left!=null) preOrder(root.left);
		if(root.right!=null) preOrder(root.right);
	}
	public  void inOrder(Node root) {
		if(root.left!=null) inOrder(root.left);
		System.out.println(root.key);
		if(root.right!=null) inOrder(root.right);
	}
}
