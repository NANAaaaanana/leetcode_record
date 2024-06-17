package learning.daliy;

/**
 * 522. 最长特殊序列II
 * 给定字符串列表 strs ，返回其中 最长的特殊序列 的长度。如果最长特殊序列不存在，返回 -1 。
 * 特殊序列 定义如下：该序列为某字符串 独有的子序列（即不能是其他字符串的子序列）。
 *  s 的 子序列可以通过删去字符串 s 中的某些字符实现。
 * 例如，"abc" 是 "aebdc" 的子序列，因为您可以删除"aebdc"中的下划线字符来得到 "abc" 。"aebdc"的子序列还包括"aebdc"、 "aeb" 和 "" (空字符串)。
 */
public class FindLUSlength2_522_0617 {
    public int findLUSlength(String[] strs) {
        int ans = -1;
        next:
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() <= ans) { // 不会让 ans 变大
                continue;
            }
            for (int j = 0; j < strs.length; j++) {
                if (j != i && isSubseq(strs[i], strs[j])) {
                    continue next;
                }
            }
            ans = strs[i].length();
        }
        return ans;
    }

    // 判断 s 是否为 t 的子序列
    private boolean isSubseq(String s, String t) {
        int i = 0;
        for (char c : t.toCharArray()) {
            if (s.charAt(i) == c && ++i == s.length()) { // 所有字符匹配完毕
                return true; // s 是 t 的子序列
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
