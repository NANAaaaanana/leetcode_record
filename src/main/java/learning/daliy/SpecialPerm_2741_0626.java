package learning.daliy;

import java.util.Arrays; /**
 * 2741. 特别的排列
 * 给你一个下标从 0 开始的整数数组 nums ，它包含 n 个 互不相同 的正整数。
 *
 * 如果 nums 的一个排列满足以下条件，我们称它是一个特别的排列：
 * 对于 0 <= i < n - 1 的下标 i ，要么 nums[i] % nums[i+1] == 0 ，要么 nums[i+1] % nums[i] == 0 。
 *
 * 请你返回特别排列的总数目，由于答案可能很大，请将它对 109 + 7 取余 后返回。
 */
public class SpecialPerm_2741_0626 {
    public static int specialPerm(int[] nums) {
        int n = nums.length;
        int u = (1 << n) - 1;
        long[][] f = new long[u][n];
        Arrays.fill(f[0], 1L);
        for (int s = 1; s < u; s++) {
            for (int i = 0; i < n; i++) {
                if ((s >> i & 1) != 0) {
                    continue;
                }
                for (int j = 0; j < n; j++) {
                    if ((s >> j & 1) != 0 && (nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0)) {
                        f[s][i] += f[s ^ (1 << j)][j];
                    }
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += f[u ^ (1 << i)][i];
        }
        return (int) (ans % 1_000_000_007);
    }

    public static void main(String[] args) {
        System.out.println("===============test 1===============");
        System.out.println("result = " + specialPerm(new int[]{1,4,3}));
    }
}
