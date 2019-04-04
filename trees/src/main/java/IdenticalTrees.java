public class IdenticalTrees {
    public static void main(String[] args) {
        Nodesh root = new Nodesh(20);
        root.left = new Nodesh(8);
        root.right = new Nodesh(22);
        root.left.left = new Nodesh(5);
        root.left.right = new Nodesh(3);

        Nodesh root1 = new Nodesh(20);
        root1.left = new Nodesh(8);
        root1.right = new Nodesh(22);
        root1.left.left = new Nodesh(5);
        root1.left.right = new Nodesh(3);

        System.out.println(identicalTrees(root,root1));
    }
        public static boolean identicalTrees(Nodesh nodeFromTree1,Nodesh nodeFromTree2){
        if(nodeFromTree1==null && nodeFromTree2==null)
            return  true;
        if((nodeFromTree1==null&& nodeFromTree2!=null)|| (nodeFromTree1!=null&& nodeFromTree2==null)){
            return false;
        }
        if(nodeFromTree1.data == nodeFromTree2.data){
            return identicalTrees(nodeFromTree1.left,nodeFromTree2.left) && identicalTrees(nodeFromTree1.right,nodeFromTree2.right);
        }
        return  false;
    }
}
