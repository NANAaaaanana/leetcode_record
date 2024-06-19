package learning.base;

/**
 * 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 */
public class MaxSubArray_53 {
    public static int maxSubArray(int[] nums) {
        int lastMax = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            lastMax = Math.max(lastMax + nums[i], nums[i]);
            maxSum = Math.max(maxSum, lastMax);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println("============test 1=============");
        System.out.println("result 1 = " + maxSubArray(new int[]{5,4,-1,7,8}));

        System.out.println("============test 2=============");
        System.out.println("result 2 = " + maxSubArray(new int[]{1}));

        System.out.println("============test 3=============");
        System.out.println("result 3 = " + maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
