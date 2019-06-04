import java.util.Map;
import java.util.TreeMap;

public class Permutations2 {
    public static void main(String[] args) {
        String s = "AABCD";
        Permutations2 permutations2 = new Permutations2();
        permutations2.permutation(s.toCharArray());
    }

    public void permutation(char[] arr) {
        Map<Character, Integer> countMap = new TreeMap<>();
        for (Character ch : arr) {
            countMap.compute(ch, (k, v) -> {
                        if (v == null) return 1;
                        else return v + 1;
                    }
            );
        }
    }
    public void printPermut(Map<Character,Integer> map){

    }
}
