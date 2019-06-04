public class EditDistance {
    public static void main(String[] args) {
        String s1 ="mani";
        String s2 ="manik";
    }

    public static int editDistance(String s1,String s2,int index1,int index2){
        if(index1==0) return index2;
        if(index2==0) return index1;
        return 0;
    }
}
