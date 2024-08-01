package learning.daliy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * LCP40. 心算挑战
 * 「力扣挑战赛」心算项目的挑战比赛中，要求选手从 N 张卡牌中选出 cnt 张卡牌，
 * 若这 cnt 张卡牌数字总和为偶数，则选手成绩「有效」且得分为 cnt 张卡牌数字总和。
 * 给定数组 cards 和 cnt，其中 cards[i] 表示第 i 张卡牌上的数字。
 * 请帮参赛选手计算最大的有效得分。若不存在获取有效得分的卡牌方案，则返回 0。
 */
public class MaxmiumScore_LCP40_0801 {

    public int maxmiumScore_Best(int[] cards, int cnt) {
        Arrays.sort(cards);
        int n = cards.length;
        int s = 0;
        for (int i = n - cnt; i < n; i++) {
            s += cards[i]; // 最大的 cnt 个数之和
        }
        if (s % 2 == 0) { // s 是偶数
            return s;
        }

        int x = cards[n - cnt];
        int ans = replaceSum(cards, cnt, s, x); // 替换 x
        for (int i = n - cnt + 1; i < n; i++) {
            if (cards[i] % 2 != x % 2) { // 找到一个最小的奇偶性和 x 不同的数
                ans = Math.max(ans, replaceSum(cards, cnt, s, cards[i])); // 替换
                break;
            }
        }
        return ans;
    }

    private int replaceSum(int[] cards, int cnt, int s, int x) {
        for (int i = cards.length - cnt - 1; i >= 0; i--) {
            if (cards[i] % 2 != x % 2) { // 找到一个最大的奇偶性和 x 不同的数
                return s - x + cards[i]; // 用 cards[i] 替换 s
            }
        }
        return 0;
    }
    public int maxmiumScore(int[] cards, int cnt) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        Arrays.stream(cards).boxed()
              .sorted(Comparator.reverseOrder())
              .forEach(x -> {
                  if(x % 2 == 0) {
                      even.add(x);
                  } else {
                      odd.add(x);
                  }});

        int result = 0;
        for ( int i = 0; i < cnt / 2 + 1; i++ ) {
            int oddCount = i * 2;
            int evenCount = cnt - oddCount;
            if ( oddCount <= odd.size() && evenCount <= even.size()) {
                int oddSum = odd.subList(0, oddCount).stream().mapToInt(x -> x).sum();
                int evenSum = even.subList(0, evenCount).stream().mapToInt(x -> x).sum();
                result = Math.max(result, oddSum + evenSum);
            } else {
                continue;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] cards = {1,2,3,4,5,6,7,8,9,10,11};
        int cnt = 3;
        System.out.println(new MaxmiumScore_LCP40_0801().maxmiumScore_Best(cards, cnt));
    }
}
