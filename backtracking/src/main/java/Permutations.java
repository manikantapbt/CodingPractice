import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Permutations {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("C:\\Users\\pattaput\\IdeaProjects\\practice\\backtracking\\src\\main\\java\\permut.txt", true);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        String str = "ABCDEFGHIJKLMNOPQRSTUVXYZ";
        int n = str.length();
        Permutations permutation = new Permutations();
        permutation.permute(str, 0, n - 1,printWriter);
    }

    private void permute(String str, int l, int r,PrintWriter printWriter) {
        if (l == r) {
            printWriter.println(str);
           // System.out.println(str);
        } else {
            for (int i = l; i <= r; i++) {
                str=swap(str,l,i);
                permute(str,l+1,r,printWriter);
                str=swap(str,l,i);
            }
        }
    }

    public String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
