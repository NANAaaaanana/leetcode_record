package learning.base;

/**
 * 5. 最长回文字串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class LongestPalindrome_5 {
    public static String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        System.out.println("============test 1=============");
        System.out.println("result 1 = " + longestPalindrome("abbac"));
    }
}
