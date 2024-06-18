package learning.daliy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 826. Most Profit Assigning Work
 *
 * You have n jobs and m workers. You are given three arrays: difficulty, profit, and worker where:
 * difficulty[i] and profit[i] are the difficulty and the profit of the ith job, and
 * worker[j] is the ability of jth worker (i.e., the jth worker can only complete a job with difficulty at most worker[j]).
 * Every worker can be assigned at most one job, but one job can be completed multiple times.
 * For example, if three workers attempt the same job that pays $1, then the total profit will be $3.
 * If a worker cannot complete any job, their profit is $0.
 * Return the maximum profit we can achieve after assigning the workers to the jobs.
 */
public class MaxProfitAssignment_826_0618 {
    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<Work> works = new ArrayList<>();
        for (int i = 0; i < difficulty.length; i++) {
            works.add(new Work(difficulty[i], profit[i]));
        }
        works.sort( Comparator.comparing(Work::getDifficulty).thenComparing(Work::getProfit));

        Arrays.sort(worker);

        // worker 坐标
        int i = 0;
        // work 坐标
        int j = 0;
        int maxProfit = 0;
        int lastProfit = 0;
        while (i < worker.length ) {
            while (j < works.size() && works.get(j).getDifficulty() <= worker[i] ) {
                lastProfit = Math.max(lastProfit, works.get(j).getProfit());
                j++;
            }
            maxProfit += lastProfit;
            i++;
        }
        return maxProfit;
    }

    static class Work {
        int difficulty;
        int profit;
        Work(int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }
        int getDifficulty() {
            return difficulty;
        }
        int getProfit() {
            return profit;
        }
    }

    public static void main(String[] args) {
        System.out.println("===============test 1===============");
        int[] difficulty = { 68,35,52,47,86 };
        int[] profit = { 67,17,1,81,3 };
        int[] work = { 92,10,85,84,82};
        System.out.println("result 1 = " + maxProfitAssignment(difficulty, profit, work));
    }
}
