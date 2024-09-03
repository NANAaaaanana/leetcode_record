package topic.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 189. Rotate Array
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 */
public class RotateArray_189 {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

    public static void main(String[] args) {
        RotateArray_189 rotateArray_189 = new RotateArray_189();
        int[] nums = new int[]{1,2,3,4,5,6,7};
        rotateArray_189.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
