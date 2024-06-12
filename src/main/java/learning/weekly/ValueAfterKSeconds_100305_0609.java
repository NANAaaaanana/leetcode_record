package learning.weekly;

/**
 * 401 周赛
 * 100305 K 秒后第 N 个元素的值
 *
 * 给你两个整数 n 和 k。
 * 最初，你有一个长度为 n 的整数数组 a，对所有 0 <= i <= n - 1，都有 a[i] = 1 。每过一秒，你会同时更新每个元素为其前面所有元素的和加上该元素本身。例如，一秒后，a[0] 保持不变，a[1] 变为 a[0] + a[1]，a[2] 变为 a[0] + a[1] + a[2]，以此类推。
 * 返回 k 秒后 a[n - 1] 的值。
 * 由于答案可能非常大，返回其对 109 + 7 取余 后的结果。
 */
public class ValueAfterKSeconds_100305_0609 {
    private static final int MOD = 1_000_000_007;
    private static final int MX = 2001;

    // 组合数模板
    private static final long[] FAC = new long[MX];
    private static final long[] INV_FAC = new long[MX];

    static {
        FAC[0] = 1;
        for (int i = 1; i < MX; i++) {
            FAC[i] = FAC[i - 1] * i % MOD;
        }
        INV_FAC[MX - 1] = pow(FAC[MX - 1], MOD - 2);
        for (int i = MX - 1; i > 0; i--) {
            INV_FAC[i - 1] = INV_FAC[i] * i % MOD;
        }
    }

    private static long comb(int n, int k) {
        return FAC[n] * INV_FAC[k] % MOD * INV_FAC[n - k] % MOD;
    }

    public static int valueAfterKSeconds(int n, int k) {
        return (int) comb(n + k - 1, k);
    }

    private static long pow(long x, int n) {
        long res = 1;
        for (; n > 0; n /= 2) {
            if (n % 2 > 0) {
                res = res * x % MOD;
            }
            x = x * x % MOD;
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println("===============test 1===============");
//        System.out.println("n = 4, k = 5");
//        System.out.println("resp = " + valueAfterKSeconds(4, 5));
        System.out.println("===============test 2===============");
        System.out.println("n = 5, k = 1000");
        System.out.println("resp = " + valueAfterKSeconds(4, 1000));
    }
}
