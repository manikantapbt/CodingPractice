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
        System.out.println("LCA(4, 4): " + LCA(root, 4, 4));

        System.out.println(LCAByPath(root, 3, 7));
        System.out.println(LCAByPath(root, 1, 3));
        System.out.println((findLCAG4G(root,3,3)).key);
        System.out.println((findLCAG4G(root,4,4)).key);
        System.out.println((findLCAG4G(root,4,999)).key); // this method assumes both the keys are present in tree
        // if not it will return the key which is present as LCA, if both keys dont exist null will be returned.
    }

    public static int LCA(Node root, int a, int b) {
        if (a == b) return a; // returns a even if node is not present in the tree
        // This is practice for recursion
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
        if ((left == 20000 && right == 10000) || (right == 20000 && left == 10000)) {
            return root.key;
        }
        if (left == -1)
            return right;
        if (right == -1)
            return left;
        return -1;
    }

    public static int LCAByPath(Node root, int a, int b) {
        ArrayList<Integer> pathForA = new ArrayList();
        findPath(root, a, pathForA);
        ArrayList<Integer> pathForB = new ArrayList();
        findPath(root, b, pathForB);
        if (pathForA.isEmpty() || pathForB.isEmpty()) {
            return -1;
        }
        int i = 0;
        for (; i < pathForA.size() && i < pathForB.size(); i++) {
            if (!(pathForA.get(i).equals(pathForB.get(i)))) {
                break;
            }
        }
        return pathForA.get(i - 1);
    }

    public static boolean findPath(Node root, int a, ArrayList<Integer> al) {
        if (root == null) return false;
        if (root.key == a) {
            al.add(root.key);
            return true;
        }
        al.add(root.key);
        boolean left = findPath(root.left, a, al);
        boolean right = findPath(root.right, a, al);
        if (left || right) {
            return true;
        }
        al.remove(al.size() - 1);
        return false;
    }

    public static Node findLCAG4G(Node root,int a,int b){
        if(root==null)
            return null;
        if(root.key==a||root.key==b){
            return root;
        }
        Node left = findLCAG4G(root.left,a,b);
        Node right= findLCAG4G(root.right,a,b);

        if(left!=null && right!=null) return root;
        return (left!=null)?left:right;

    }
}
