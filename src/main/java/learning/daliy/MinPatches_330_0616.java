package learning.daliy;

/**
 * 330 Patching Array
 * Given a sorted integer array nums and an integer n,
 * add/patch elements to the array such that any number in the range [1, n] inclusive can be formed by the sum of some elements in the array.
 * Return the minimum number of patches required.
 */
public class MinPatches_330_0616 {
    public static int minPatches(int[] nums, int n) {
        int ans = 0, i = 0;
        long s = 1;
        while (s <= n) {
            if (i < nums.length && nums[i] <= s) {
                s += nums[i++];
            } else {
                s *= 2;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("===============test 1===============");
        System.out.println("result 1 = " + minPatches(new int[]{1,5,10}, 20));
    }
}
