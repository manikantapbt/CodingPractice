import java.lang.reflect.Array;
import java.util.ArrayList;

public class LowestCommonAncestor {
    String aFound = "aFound";
    String bFound = "bFound";
    String nullFound = "nullFound";

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println("LCA(4, 5): " + LCA(root, 4, 5));
        System.out.println("LCA(4, 6): " + LCA(root, 4, 6));
        System.out.println("LCA(3, 4): " + LCA(root, 3, 4));
        System.out.println("LCA(2, 4): " + LCA(root, 2, 4));
        System.out.println("LCA(3, 7): " + LCA(root, 3, 7));
        System.out.println("LCA(4, 7): " + LCA(root, 4, 7));
        LCAByPath(root,3,7);
    }

    public static int LCA(Node root, int a, int b) {
        // This is practice recursion
        // traverse the tree only once to find LCA
        if (root == null) return -1;
        int left = LCA(root.left, a, b);
        int right = LCA(root.right, a, b);
        if (root.key == a && (left == -1 && right == -1)) {
            return 10000;
        }
        if (root.key == b && (left == -1 && right == -1)) {
            return 20000;
        }
        if (root.key == a && (left == 20000 || right == 20000)) {
            return root.key;
        }
        if (root.key == b && (left == 10000 || right == 20000)) {
            return root.key;
        }
        if((left==20000 && right==10000)||(right==20000 && left==10000)){
            return root.key;
        }
        if(left==-1)
            return right;
        if(right==-1)
            return left;
        return -1;
    }
    public static void LCAByPath(Node root,int a,int b){
        ArrayList<Integer> pathForA =new ArrayList();
        findPath(root,a,pathForA);
        System.out.println("pathForA = " + pathForA);
        ArrayList<Integer> pathForB =new ArrayList();
        findPath(root,b,pathForB);
        System.out.println("pathForB = " + pathForB);

        int i=0;
        for ( ; i <pathForA.size() && i<pathForB.size() ; i++) {
            if(!(pathForA.get(i)==pathForB.get(i))){
                break;
            }
        }
        System.out.println("LCA("+a+","+b +"): " + pathForA.get(i-1));
    }
    public static boolean findPath(Node root,int a,ArrayList<Integer> al){
        if(root==null) return false;
        if(root.key==a) {
            al.add(root.key);
            return true;
        }
        al.add(root.key);
        boolean left =findPath(root.left,a,al);
        boolean right=findPath(root.right,a,al);
        if(left||right){
            return true;
        }
        al.remove(al.size()-1);
        return false;
    }
}
