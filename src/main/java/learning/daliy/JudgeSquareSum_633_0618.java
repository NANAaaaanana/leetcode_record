package learning.daliy;

/**
 * 633. Sum of Square Numbers
 * Given a non-negative integer c,
 * decide whether there're two integers a and b such that a2 + b2 = c.
 */
public class JudgeSquareSum_633_0618 {
    public static boolean judgeSquareSum(int c) {
        int max = (int) Math.sqrt(c);
        for (int a = 0; a <= max; a++) {
            int b = (int) Math.sqrt(c - a * a);
            if (a * a + b * b  == c) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("result 1 = " + judgeSquareSum(17));
    }
}
