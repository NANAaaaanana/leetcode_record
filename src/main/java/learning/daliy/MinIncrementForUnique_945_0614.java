package learning.daliy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 945. minimum increment to make array unique
 * You are given an integer array nums. In one move, you can pick an index i where 0 <= i < nums.length and increment nums[i] by 1.
 * Return the minimum number of moves to make every value in nums unique.
 * The test cases are generated so that the answer fits in a 32-bit integer.
 */
public class MinIncrementForUnique_945_0614 {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);

        int count = 0;
        int current = 0;
        for (int num : nums) {
            current = Math.max(num, current);
            count += current - num ;
            current++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("minIncrementForUnique");
    }
}
