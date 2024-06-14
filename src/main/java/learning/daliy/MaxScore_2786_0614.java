package learning.daliy;

import java.util.ArrayList;
import java.util.List;

/**
 * 2786. 访问数组中的位置使分数最大
 * 给你一个下标从 0 开始的整数数组 nums 和一个正整数 x 。
 * 你 一开始 在数组的位置 0 处，你可以按照下述规则访问数组中的其他位置：
 * 如果你当前在位置 i ，那么你可以移动到满足 i < j 的 任意 位置 j 。
 * 对于你访问的位置 i ，你可以获得分数 nums[i] 。
 * 如果你从位置 i 移动到位置 j 且 nums[i] 和 nums[j] 的 奇偶性 不同，那么你将失去分数 x 。
 * 请你返回你能得到的 最大 得分之和。
 * 注意 ，你一开始的分数为 nums[0] 。
 */
public class MaxScore_2786_0614 {

    public static long maxScore(int[] nums, int x) {
        long result = 0;

        long tmpEven = 0;
        long tmpOdd = 0;
        if (nums[0] % 2 == 0) {
            tmpEven = nums[0];
            tmpOdd = nums[0] - x ;
        } else {
            tmpOdd = nums[0];
            tmpEven = nums[0] - x;
        }

        System.out.println("nums[0] = " + nums[0] + ", tmpEven = " + tmpEven + ", tmpOdd = " + tmpOdd );
        for (int i = 1; i < nums.length; i++) {
            long current = 0;
            boolean isEven = nums[i] % 2 == 0;

            current = isEven ? Math.max(tmpEven + nums[i], tmpOdd + nums[i] - x)
                             : Math.max(tmpEven + nums[i] - x, tmpOdd + nums[i]) ;

            result = Math.max(result, current);
            if (isEven) {
                tmpEven = Math.max(current, tmpEven);
            } else {
                tmpOdd = Math.max(current, tmpOdd);
            }
            System.out.println("nums[i] = " + nums[i] + ", tmpEven = " + tmpEven + ", tmpOdd = " + tmpOdd + ", result = " + result);
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println("===============test 1===============");
        int[] nums = new int[]{8,50,65,85,8,73,55,50,29,95,5,68,52,79};
        System.out.println("result 1 = " +  maxScore(nums, 74));
    }
}
