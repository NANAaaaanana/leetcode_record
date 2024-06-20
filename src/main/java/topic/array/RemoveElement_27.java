package topic.array;

/**
 * 27. Remove Element
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
 * Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
 * Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 *
 * Custom Judge:
 * The judge will test your solution with the following code:
 * int[] nums = [...]; // Input array
 * int val = ...; // Value to remove
 * int[] expectedNums = [...]; // The expected answer with correct length.
 *                             // It is sorted with no values equaling val.
 * int k = removeElement(nums, val); // Calls your implementation
 * assert k == expectedNums.length;
 * sort(nums, 0, k); // Sort the first k elements of nums
 * for (int i = 0; i < actualLength; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 * If all assertions pass, then your solution will be accepted.
 */
public class RemoveElement_27 {
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if ( nums[i] == val ) {
                int j = i + 1;
                while (j < nums.length && nums[j] == val) {
                    j++;
                }
                if (j == nums.length) {
                    break;
                }
                nums[i] = nums[j];
                nums[j] = val;
            }
        }

        int count = 0;
        while (count < nums.length && nums[count] != val) {
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("===============test 1===============");
        int[] nums = {3, 2, 2, 3};
        System.out.println("resp = " + removeElement(nums, 3));
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i] + " ");
        }
        System.out.println("nums = " + sb.toString());

        System.out.println("===============test 2===============");
        int[] nums2 = {0,1,2,2,3,0,4,2};
        System.out.println("resp = " + removeElement(nums2, 2));
        StringBuffer sb2 = new StringBuffer();
        for (int i = 0; i < nums2.length; i++) {
            sb2.append(nums2[i] + " ");
        }
        System.out.println("nums = " + sb2.toString());
    }
}
