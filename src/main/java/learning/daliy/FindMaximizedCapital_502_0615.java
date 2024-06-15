package learning.daliy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 502. IPO
 * Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, LeetCode would like to work on some projects to increase its capital before the IPO.
 * Since it has limited resources, it can only finish at most k distinct projects before the IPO.
 * Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.
 *
 * You are given n projects where the ith project has a pure profit profits[i] and a minimum capital of capital[i] is needed to start it.
 *
 * Initially, you have w capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.
 * Pick a list of at most k distinct projects from given projects to maximize your final capital, and return the final maximized capital.
 * The answer is guaranteed to fit in a 32-bit signed integer.
 */
public class FindMaximizedCapital_502_0615 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        if (profits == null || profits.length == 0
            || capital == null || capital.length == 0
            || capital.length != profits.length) {
            return 0;
        }

        List<ProfitAndCaptial> profitAndCapitalList = new ArrayList<>();
        for (int i = 0; i < profits.length; i++) {
            profitAndCapitalList.add(new ProfitAndCaptial(profits[i], capital[i]));
        }

        profitAndCapitalList.sort(Comparator.comparing(ProfitAndCaptial::getCapital, Comparator.naturalOrder())
                                            .thenComparing(ProfitAndCaptial::getProfit, Comparator.reverseOrder()));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x);
        int i = 0;
        for (int j = 0; j < k; j++) {
            // Add all profitable projects that we can afford
            while (i < profits.length && profitAndCapitalList.get(i).capital <= w) {
                maxHeap.add(profitAndCapitalList.get(i).profit);
                i++;
            }

            if (maxHeap.isEmpty()) {
                break;
            }

            w += maxHeap.poll();
        }
        return w;
    }

    class ProfitAndCaptial {
        int profit;
        int capital;
        ProfitAndCaptial(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }

        int getProfit() {
            return profit;
        }

        int getCapital() {
            return capital;
        }
    }

    public static void main(String[] args) {
        System.out.println("findMaximizedCapital");
    }
}
