package learning.daliy;

import java.util.Arrays;

/**
 * 3038 相同数目的最大操作数目1
 *
 * 给你一个整数数组 nums ，如果 nums 至少 包含 2 个元素，你可以执行以下操作：
 *
 * 选择 nums 中的前两个元素并将它们删除。
 * 一次操作的 分数 是被删除元素的和。
 *
 * 在确保 所有操作分数相同 的前提下，请你求出 最多 能进行多少次操作。
 *
 * 请你返回按照上述要求 最多 可以进行的操作次数。
 */
public class MaxOperations_3038_0607 {
    public static int maxOperations(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        int score = nums[0] + nums[1];
        int count = 1;

        for(int i = 2; i < nums.length-1 ; i += 2) {

            if(nums[i] + nums[i+1] == score) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("===============test 1===============");
        int[] nums1 = {3,2,1,4,5};
        int res1 = maxOperations(nums1);
        System.out.println("nums = " + Arrays.toString(nums1));
        System.out.println("res = " + res1);

        System.out.println("===============test 2===============");
        int[] nums2 = {2,2,3,2,4,2,3,3,1,3};
        int res2 = maxOperations(nums2);
        System.out.println("nums = " + Arrays.toString(nums2));
        System.out.println("res = " + res2);
    }
}
