import java.util.ArrayList;
import java.util.List;

public class InOrderSuccessor {

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


	  
		inorderSuccessor(root, root.left.right.right.left.right);  

		//System.out.println(.key);
	}

	public static Node leftMost(Node root) {
		while(root!=null && root.left!=null)
			root= root.left;
		return root;
	}

	public static Node inorderSuccessor(Node root,Node x) {
		if(x.right!=null) {
			Node leftm = leftMost(x.right);
			System.out.println(leftm.key);
			return leftm;
		}
		else {
			List<NodeDescripPath> list = new ArrayList<>();
			
			inorderSuccessorWhenRightIsNullNoMem(root,x);
			
			inorderSuccessorWhenRightIsNull(root,x,list);
			System.out.println(list);
			for(int i=0;i<list.size();i++) {
				if(list.get(i).path.equals("left"))
				{
					System.out.println("in order Successor is " + list.get(i).key);
					break;
				}
			}
			return null;
		}
	}
	
	private static Node inorderSuccessorWhenRightIsNull(Node root,Node x,List<NodeDescripPath> list) {
		if(root==null) {
			return null;
		}
		if(root.key==x.key){
			return root;
		}
		
		Node left =inorderSuccessorWhenRightIsNull(root.left,x,list);
		Node right=inorderSuccessorWhenRightIsNull(root.right,x,list);
		
		if(left!=null) {
			NodeDescripPath  n = new NodeDescripPath("left",root.key);
			list.add(n);
			return left;
		}
		if(right!=null) {
			NodeDescripPath  n = new NodeDescripPath("right",root.key);
			list.add(n);
			return right;
		}
		return null;
	}
	private static Node inorderSuccessorWhenRightIsNullNoMem(Node root,Node x) {
		if(root==null) {
			return null;
		}
		if(root.key==x.key){
			return root;
		}
		
		Node left =inorderSuccessorWhenRightIsNullNoMem(root.left,x);
		Node right=inorderSuccessorWhenRightIsNullNoMem(root.right,x);
		
		if(left!=null) {
			System.out.println("inOrder Successor is "+ root.key );
			return null;
		}
		if(right!=null) {
			return root;
		}
		return null;
	}
	private Node search(int  key, Node node){
	    if(node != null){
	        if(node.key==key){
	           return node;
	        } else {
	            Node foundNode = search(key, node.left);
	            if(foundNode == null) {
	                foundNode = search(key, node.right);
	            }
	            return foundNode;
	         }
	    } else {
	        return null;
	    }
	}
}
class NodeDescripPath {
	String path;
	int key;
	NodeDescripPath(String path,int key){
		this.path = path;
		this.key = key;
	}
	@Override
	public String toString() {
		return "NodeDescripPath [path=" + path + ", key=" + key + "]";
	}
}