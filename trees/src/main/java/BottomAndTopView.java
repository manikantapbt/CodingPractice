import java.util.ArrayDeque;
import java.util.Map;
import java.util.TreeMap;

public class BottomAndTopView {
    public static void main(String[] args) {
//        Nodesh root = new Nodesh(1);
//        root.left = new Nodesh(2);
//        root.right = new Nodesh(3);
//        root.left.left = new Nodesh(4);
//        root.left.right = new Nodesh(5);
//        root.right.left = new Nodesh(6);
//        root.left.right.left = new Nodesh(8);
//        root.left.right.left.right = new Nodesh(9);
        Nodesh root = new Nodesh(20);
        root.left = new Nodesh(8);
        root.right = new Nodesh(22);
        root.left.left = new Nodesh(5);
        root.left.right = new Nodesh(3);
        root.right.left = new Nodesh(4);
        root.right.right = new Nodesh(25);
        root.left.right.left = new Nodesh(10);
        root.left.right.right = new Nodesh(14);
        Map<Integer, Integer> map = bottomViewOfTree(root);
        System.out.println("bottom = " + map);
        Map<Integer, Integer> topViewmap = topView(root);
        System.out.println("top = " + topViewmap);

        Nodesh root1 = new Nodesh(1);
        root1.left = new Nodesh(2);
        root1.right = new Nodesh(3);
        root1.left.right = new Nodesh(4);
        root1.left.right.right = new Nodesh(5);
        root1.left.right.right.right = new Nodesh(6);
        Map<Integer, Integer> topViewmap1 = topView(root1);
        System.out.println("top = " + topViewmap1);
    }
    public static Map<Integer,Integer> topView(Nodesh root){
        Map<Integer,Integer> map = new TreeMap<>();
        ArrayDeque<Nodesh> dq = new ArrayDeque<>();
        dq.add(root);
        root.hd=0;
        while(!dq.isEmpty()){
            Nodesh node = dq.pop();
            map.putIfAbsent(node.hd,node.data);
            if(node.left!=null){
                node.left.hd=node.hd-1;
                dq.add(node.left);
            }
            if(node.right!=null){
                node.right.hd=node.hd+1;
                dq.add(node.right);
            }
        }
        return map;
    }
    public static Map<Integer, Integer> bottomViewOfTree(Nodesh root) {
        Map<Integer, Integer> keysToDepth = new TreeMap<Integer, Integer>();
        ArrayDeque<Nodesh> dq = new ArrayDeque<Nodesh>();
        root.hd=0;
        dq.add(root);
        while (!dq.isEmpty()) {
            Nodesh node = dq.pop();
            keysToDepth.put(node.hd,node.data);
            if(node.left!=null) {
                node.left.hd=node.hd-1;
                dq.add(node.left);
            }
            if(node.right!=null) {
                node.right.hd=node.hd+1;
                dq.add(node.right);
            }
        }
        return keysToDepth;
    }
}

class Nodesh {
    int data;
    int hd;
    Nodesh left;
    Nodesh right;
    Nodesh(int data){
        this.data=data;
    }
}
