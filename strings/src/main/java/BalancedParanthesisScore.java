import java.util.Stack;

public class BalancedParanthesisScore {
    public static void main(String[] args) {
        String s = "(()(()))";

        Stack<ScoreMeasure> stack = new Stack<>();
        int scoreS = 0;
        for (int i = 0; i < s.length(); i++) {
            ScoreMeasure sm = new ScoreMeasure();
            sm.s = s.charAt(i);
            stack.push(sm);
            scoreS = score(stack);
        }
        System.out.println(2 * scoreS);
    }

    public static int score(Stack<ScoreMeasure> stack) {
        return 1;
    }
}

class ScoreMeasure {
    Character s;
    int score;
}
