package learning.weekly;

import java.util.Arrays;

/**
 * 401 周赛
 * 100319 执行操作可获得的最大总奖励 I
 * 给你一个整数数组 rewardValues，长度为 n，代表奖励的值。
 * 最初，你的总奖励 x 为 0，所有下标都是 未标记 的。你可以执行以下操作 任意次 ：
 * 从区间 [0, n - 1] 中选择一个 未标记 的下标 i。
 * 如果 rewardValues[i] 大于 你当前的总奖励 x，则将 rewardValues[i] 加到 x 上（即 x = x + rewardValues[i]），并 标记 下标 i。
 * 以整数形式返回执行最优操作能够获得的 最大 总奖励。
 */
public class MaxTotalReward_100319_0609 {
    // 未ac解答
    public static int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int maxScore = 0;

        for (int i = 0; i < rewardValues.length ; i++) {
            int score = rewardValues[i];
            int lastScore = -1;
            for (int j = i + 1; j < rewardValues.length; j++) {
                if(  rewardValues[j] > score ) {
                    lastScore = score;
                    score += rewardValues[j];
                } else if( rewardValues[j] > lastScore ) {
                    score = lastScore + rewardValues[j];
                }
            }
            maxScore = Math.max(maxScore, score);
        }
        return maxScore;
    }

    public static void main(String[] args) {
//        System.out.println("===============test 1===============");
//        int[] rewardValues1 = new int[]{2, 15, 14, 18};
//        System.out.println("result = " + maxTotalReward(rewardValues1));
//
//        System.out.println("===============test 2===============");
//        int[] rewardValues2 = new int[]{1, 1, 3, 3};
//        System.out.println("result = " + maxTotalReward(rewardValues2));
//
//        System.out.println("===============test 3===============");
//        int[] rewardValues3 = new int[]{1,6,4,3,2};
//        System.out.println("result = " + maxTotalReward(rewardValues3));

        System.out.println("===============test 4===============");
        int[] rewardValues4 = new int[]{2,15,19,6};
        System.out.println("result = " + maxTotalReward(rewardValues4));
    }
}
