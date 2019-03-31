public class InorderFromPreAndPost {
    static int  staticIndex=0;
    public static void main(String[] args) {
        int pre[] = { 1, 2, 4, 8, 9, 5, 3, 6, 7 };
        int post[] = { 8, 9, 4, 5, 2, 6, 7, 3, 1 };
        Node root = inorderFromPreAndPost(pre,post,0,pre.length-1);
        inOrderTraversal(root);
    }
    public static Node inorderFromPreAndPost(int[] pre,int[] post,int low,int high){

        if(staticIndex>=pre.length) return  null;
        if(low>high) return null;
        Node node = new Node(pre[staticIndex]);
        staticIndex++;

        if (low == high || staticIndex>=pre.length)
            return node;
        int i=low;
        for (; i <=high ; i++) {
            if(post[i]==pre[staticIndex]){
                break;
            }
        }
        if(i<=high) {
            node.left = inorderFromPreAndPost(pre, post, low, i);
            node.right = inorderFromPreAndPost(pre, post, i + 1, high);
        }
        return node;
    }
    public static void inOrderTraversal(Node root){
        if(root==null) return;
        inOrderTraversal(root.left);
        System.out.print(root.key+" ");
        inOrderTraversal(root.right);
    }
}
