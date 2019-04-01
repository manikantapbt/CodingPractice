import java.util.ArrayDeque;
import java.util.ArrayList;

public class LeftAndRightView {
    public static void main(String[] args) {
        Node root1 = new Node(20);
        root1.left = new Node(8);
        root1.right = new Node(22);
        root1.left.left = new Node(5);
        root1.left.right = new Node(3);
        printLeftView(root1);
        printRightView(root1);
    }

    public static void printLeftView(Node root) {
        System.out.println("Left View");
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(root);
        while (!dq.isEmpty()) {
            Node nodeleft = dq.peek();
            System.out.println(nodeleft.key + " ");
            ArrayList<Node> al = new ArrayList<>();
            for (Node node : dq) {
                if (node.left != null)
                    al.add(node.left);
                if (node.right != null)
                    al.add(node.right);
            }
            dq.clear();
            dq.addAll(al);
        }
    }
    public static void printRightView(Node root){
        System.out.println("Right View");
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(root);
        while (!dq.isEmpty()) {
            Node nodeleft = dq.peek();
            System.out.println(nodeleft.key + " ");
            ArrayList<Node> al = new ArrayList<>();
            for (Node node : dq) {
                if (node.right != null)
                    al.add(node.right);
                if (node.left != null)
                    al.add(node.left);
            }
            dq.clear();
            dq.addAll(al);
        }
    }
}
