package learning.daliy;

import java.util.HashMap;
import java.util.Map;

/**
 * 3154. 到达第k级台阶的方案数
 * 给你有一个 非负 整数 k 。有一个无限长度的台阶，最低 一层编号为 0 。
 *
 * Alice 有一个整数 jump ，一开始值为 0 。Alice 从台阶 1 开始，可以使用 任意 次操作，目标是到达第 k 级台阶。假设 Alice 位于台阶 i ，一次 操作 中，Alice 可以：
 *
 * 向下走一级到 i - 1 ，但该操作 不能 连续使用，如果在台阶第 0 级也不能使用。
 * 向上走到台阶 i + 2jump 处，然后 jump 变为 jump + 1 。
 * 请你返回 Alice 到达台阶 k 处的总方案数。
 *
 * 注意，Alice 可能到达台阶 k 处后，通过一些操作重新回到台阶 k 处，这视为不同的方案。
 */
public class WaysToReachStair_3154_0820 {
    public static int waysToReachStair(int k) {
        return dfs(1, 0, 0, k, new HashMap<>());
    }

    private static int dfs(int i, int j, int preDown, int k, Map<Long, Integer> memo) {
        if (i > k + 1) { // 无法到达终点 k
            return 0;
        }
        // 把状态 (i, j, preDown) 压缩成一个 long
        long mask = (long) i << 32 | j << 1 | preDown;
        if (memo.containsKey(mask)) { // 之前算过了
            return memo.get(mask);
        }
        int res = i == k ? 1 : 0;
        res += dfs(i + (1 << j), j + 1, 0, k, memo); // 操作二
        if (preDown == 0 && i > 0) {
            res += dfs(i - 1, j, 1, k, memo); // 操作一
        }
        memo.put(mask, res); // 记忆化
        return res;
    }

    public static void main(String[] args) {
        System.out.println(waysToReachStair(3));
    }
}
