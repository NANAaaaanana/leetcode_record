package learning.daliy;

import java.util.Arrays;

/**
 * 2779. 数组的最大美丽值
 * 给你一个下标从 0 开始的整数数组 nums 和一个 非负 整数 k 。
 * 在一步操作中，你可以执行下述指令：
 * 在范围 [0, nums.length - 1] 中选择一个 此前没有选过 的下标 i 。
 * 将 nums[i] 替换为范围 [nums[i] - k, nums[i] + k] 内的任一整数。
 * 数组的 美丽值 定义为数组中由相等元素组成的最长子序列的长度。
 * 对数组 nums 执行上述操作任意次后，返回数组可能取得的 最大 美丽值。
 * 注意：你 只 能对每个下标执行 一次 此操作。
 * 数组的 子序列 定义是：经由原数组删除一些元素（也可能不删除）得到的一个新数组，且在此过程中剩余元素的顺序不发生改变。
 */
public class MaximumBeauty_2779_0615 {
    public static int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int move = nums[0] - k;
        int size = move > 0 ? nums[nums.length - 1] + k : nums[nums.length - 1] + k - move ;
        int[] indexList = new int[size + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums[i] - k; j < nums[i] + k + 1; j++) {
                if (move > 0) {
                    indexList[j]++;
                } else {
                    indexList[j-move]++;
                }
            }
        }
        return Arrays.stream(indexList).max().getAsInt();

    }

    public static void main(String[] args) {
        System.out.println("===============test 1===============");
        System.out.println("result 1 = "+ maximumBeauty(new int[]{13,46,71}, 29));
        // -16 42, 17 75, 42 100
        // 0 58, 33 91, 58 116

        System.out.println("===============test 2===============");
        System.out.println("result 2 = "+ maximumBeauty(new int[]{13,46,71}, 29));
        // -16 42, 17 75, 42 100
        // 0 58, 33 91, 58 116
    }
}
