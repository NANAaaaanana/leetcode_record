package learning.daliy;

/**
 * 1717.  Maximum Score From Removing Substrings
 *You are given a string s and two integers x and y. You can perform two types of operations any number of times.
 *
 * Remove substring "ab" and gain x points.
 * For example, when removing "ab" from "cabxbae" it becomes "cxbae".
 * Remove substring "ba" and gain y points.
 * For example, when removing "ba" from "cabxbae" it becomes "cabxe".
 * Return the maximum points you can gain after applying the above operations on s.
 *
 */
public class MaximumGain_1717_0712 {
    public int maximumGain(String s, int x, int y) {
        int aCount = 0;
        int bCount = 0;
        int lesser = Math.min(x, y);
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c > 'b') {
                result += Math.min(aCount, bCount) * lesser;
                aCount = 0;
                bCount = 0;
            } else if (c == 'a') {
                if (x < y && bCount > 0) {
                    bCount--;
                    result += y;
                } else {
                    aCount++;
                }
            } else {
                if (x > y && aCount > 0) {
                    aCount--;
                    result += x;
                } else {
                    bCount++;
                };
            }
        }

        result += Math.min(aCount, bCount) * lesser;

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumGain_1717_0712().maximumGain("cdbcbbaaabab", 4, 5));
    }
}
