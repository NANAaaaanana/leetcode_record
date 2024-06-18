package learning.base;

public class LongestCommonSubsequence_1143 {
    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) {
            return 0;
        }

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i < text1.length()+1; i++) {
            for (int j = 1; j < text2.length()+1; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[ i - 1 ][ j - 1 ] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        System.out.println("============test 1=============");
        System.out.println("result 1 = " + longestCommonSubsequence("abcde", "ace"));

        System.out.println("============test 2=============");
        System.out.println("result 2 = " + longestCommonSubsequence("abc", "abc"));

        System.out.println("============test 3=============");
        System.out.println("result 3 = " + longestCommonSubsequence("psnw", "vozsh"));
    }
}
