package learning.base;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 121.买卖股票的最佳时机
 *
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。
 * 设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。
 * 如果你不能获取任何利润，返回 0 。
 */
public class MaxProfit_121 {
    // 暴力破解
    public int maxProfit_1(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        List<PricesAndSituation> list = new ArrayList<>();
        for (int i = 0; i < prices.length; i++) {
            list.add(new PricesAndSituation(prices[i], i));
        }

        list.sort(Comparator.comparing(PricesAndSituation::getPrice, Comparator.naturalOrder()));
        int maxProfit = 0;
        int left = 0;

        for (int i = 0; i < prices.length; i++) {
            left = i;
            int right = prices.length-1;
            int currentPrice = 0;
            while (right > left) {
                if( list.get(right).situation < list.get(left).situation ) {
                    right--;
                    continue;
                }
                currentPrice = list.get(right).price - list.get(left).price;
                break;
            }
            maxProfit = Math.max(maxProfit, currentPrice);
        }
        return maxProfit;
    }

    class PricesAndSituation {
        private int price;

        private int situation;

        public int getPrice(){
            return price;
        }

        public int getSituation() {
            return situation;
        }


        public PricesAndSituation(int price, int situation) {
        this.price = price;
        this.situation = situation;
        }
    }


    // 动态规划
    public static int maxProfit_2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println("===============test 1===============");
        int[] prices = {1,2,3,4,5};
        System.out.println("result 1 = " + maxProfit_2(prices));
    }
}
