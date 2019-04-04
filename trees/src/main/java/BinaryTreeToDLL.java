public class BinaryTreeToDLL {
   public static DLL prev ;
   public static DLL rootOfDLL;
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        binaryTeeeToDll(root);
        while(rootOfDLL!=null){
            System.out.println(rootOfDLL.data);
            rootOfDLL=rootOfDLL.next;
        }
    }
    public static DLL binaryTeeeToDll(Node root){
       if(root==null)
           return null;
        binaryTeeeToDll(root.left);
        DLL dll = new DLL();
        dll.data=root.key;
        if(prev!=null){
            prev.next=dll;
            dll.prev=prev;
            prev=dll;
        }
        else{
            prev=dll;
            rootOfDLL=dll;
        }
        binaryTeeeToDll(root.right);

        return dll;

    }
}
class DLL{
    int data;
    DLL prev;
    DLL next;
}
