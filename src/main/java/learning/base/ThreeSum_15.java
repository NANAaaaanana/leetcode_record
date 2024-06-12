package learning.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 15 三数之和
 */
public class ThreeSum_15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            if(nums[i] > 0){
                break;
            }

            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            Set<Integer> secondSet = new HashSet<>();
            for(int j = i+1; j < len; j++){
                Integer second = -(nums[j] + nums[i]);
                if(secondSet.contains(second)){
                    res.add(Arrays.asList(nums[i], nums[j], second));
                    while(j < len-1 && nums[j] == nums[j+1]){
                        j++;
                    }
                }
                secondSet.add(nums[j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("===============test 1===============");
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res1 = threeSum(nums1);
        System.out.println("nums = " + Arrays.toString(nums1));
        System.out.println("res = " + res1);

        System.out.println("===============test 2===============");
        int[] nums2 = {0,0,0,0};
        List<List<Integer>> res2 = threeSum(nums2);
        System.out.println("nums = " + Arrays.toString(nums2));
        System.out.println("res = " + res2);

        System.out.println("===============test 3===============");
        int[] nums3 = {-2,0,1,1,2};
        List<List<Integer>> res3 = threeSum(nums3);
        System.out.println("nums = " + Arrays.toString(nums3));
        System.out.println("res = " + res3);
    }
}
