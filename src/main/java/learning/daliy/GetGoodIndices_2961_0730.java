package learning.daliy;

import java.util.ArrayList;
import java.util.List;

/**
 * 2961. 双模幂运算
 * 给你一个下标从 0 开始的二维数组 variables ，其中 variables[i] = [ai, bi, ci, mi]，以及一个整数 target 。
 * 如果满足以下公式，则下标 i 是 好下标：
 * - 0 <= i < variables.length
 * - ((aibi % 10)ci) % mi == target
 * 返回一个由 好下标 组成的数组，顺序不限 。
 */
public class GetGoodIndices_2961_0730 {
    public static List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < variables.length; i++) {
            if (isGoodIndices(variables[i], target)) {
                result.add(i);
            }
        }
        return result;
    }

    public static boolean isGoodIndices(int[] arr, int target) {
        int a = arr[0], b = arr[1], c = arr[2], m = arr[3];
        return power(power(a, b, 10), c, m) == target;
    }

    private static int power(int base, int exponent, int mod) {
        int result = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exponent = exponent / 2;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] variables = {{2,2,3,2},{1,3,3,2},{3,2,2,3},{3,1,2,3},{1,2,3,1},{2,2,2,2},{2,1,3,1},{3,2,2,2},{2,1,3,1},{3,3,1,3}};
        System.out.println(getGoodIndices(variables, 0));
    }
}
