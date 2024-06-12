package learning.daliy;

/**
 * 75. Sort Colors
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * You must solve this problem without using the library's sort function.
 */
public class SortColors_75_0612 {
    public void sortColors(int[] nums) {
        int redCount = 0;
        int whiteCount = 0;
        int blueCount = 0;
        for(int num : nums) {
            if(num == 0) {
                redCount++;
            } else if(num == 1) {
                whiteCount++;
            } else if(num == 2) {
                blueCount++;
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(i < redCount) {
                nums[i] = 0;
            } else if(i < redCount + whiteCount) {
                nums[i] = 1;
            } else if(i < blueCount + whiteCount + redCount) {
                nums[i] = 2;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("");
    }
}
