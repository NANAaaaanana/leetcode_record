package topic.array;

/**
 * 55. Jump Game
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 */
public class JumpGame_55 {
    public boolean canJump(int[] nums) {
        int maxReachable = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i > maxReachable) {
                return false;
            }
            maxReachable = Math.max(maxReachable, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(new JumpGame_55().canJump(nums));
    }
}
