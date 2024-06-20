package topic.array;

/**
 * 80. Remove Duplicates From Sorted Array II
 * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 * Return k after placing the final result in the first k slots of nums.
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Custom Judge:
 * The judge will test your solution with the following code:
 * int[] nums = [...]; // Input array
 * int[] expectedNums = [...]; // The expected answer with correct length
 * int k = removeDuplicates(nums); // Calls your implementation
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 * If all assertions pass, then your solution will be accepted.
 */
public class RemoveDuplicates2_80 {
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;
        int count = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] < nums[i]) {
                continue;
            }

            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
                count = 1;
            } else {
                if (count < 2) {
                    i++;
                    nums[i] = nums[j];
                    count++;
                }
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        System.out.println("===============test 1===============");
        int[] nums = {0,0,1,1,1,1,2,3,3};
        System.out.println("resp = " + removeDuplicates(nums));
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i] + " ");
        }
        System.out.println("nums = " + sb.toString());
    }
}
