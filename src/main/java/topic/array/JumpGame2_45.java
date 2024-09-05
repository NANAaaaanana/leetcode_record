package topic.array;

/**
 * 45. 跳跃游戏 II
 * You are given a 0-indexed array of integers nums of length n.
 * You are initially positioned at nums[0].
 * Each element nums[i] represents the maximum length of a forward jump from index i.
 * In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 *  0 <= j <= nums[i] and
 *  i + j < n
 * Return the minimum number of jumps to reach nums[n - 1].
 * The test cases are generated such that you can reach nums[n - 1].
 */
public class JumpGame2_45 {
    public int jump(int[] nums) {
        int current = 0;
        int maxReachable = 0;
        int jumped = 0;
        if(nums.length <= 1){
            return 0;
        }
        for( int i = 0; i < nums.length; i++ ){
            maxReachable = Math.max(maxReachable, i + nums[i]);

            if(i == current){
                jumped++;
                current = maxReachable;
                if(current >= nums.length - 1){
                    break;
                }
            }

        }
        return jumped;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGame2_45().jump(new int[]{2,3,1,1,4}));
    }
}
