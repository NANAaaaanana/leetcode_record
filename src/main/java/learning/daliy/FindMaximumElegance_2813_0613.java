package learning.daliy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 2813 子序列最大优雅度
 *
 * 给你一个长度为 n 的二维整数数组 items 和一个整数 k 。
 * items[i] = [profiti, categoryi]，其中 profiti 和 categoryi 分别表示第 i 个项目的利润和类别。
 * 现定义 items 的 子序列 的 优雅度 可以用 total_profit + distinct_categories2 计算，其中 total_profit 是子序列中所有项目的利润总和，distinct_categories 是所选子序列所含的所有类别中不同类别的数量。
 * 你的任务是从 items 所有长度为 k 的子序列中，找出 最大优雅度 。
 * 用整数形式表示并返回 items 中所有长度恰好为 k 的子序列的最大优雅度。
 * 注意：数组的子序列是经由原数组删除一些元素（可能不删除）而产生的新数组，且删除不改变其余元素相对顺序。
 */
public class FindMaximumElegance_2813_0613 {

    // 答案解法
    // 1. Arrays.sort(items, (item0, item1) -> item1[0] - item0[0]); 可以节省一波内存
    // 2. ArrayDeque 队列的使用
    // 3. HashSet 各类函数的使用
    public static long findMaximumElegance0(int[][] items, int k) {
        Arrays.sort(items, (item0, item1) -> item1[0] - item0[0]);
        var categorySet = new HashSet<Integer>();
        long profit = 0, res = 0;
        var st = new ArrayDeque<Integer>();
        for (int i = 0; i < items.length; i++) {
            if (i < k) {
                profit += items[i][0];
                if (!categorySet.add(items[i][1])) {
                    st.push(items[i][0]);
                }
            } else if (!st.isEmpty() && categorySet.add(items[i][1])) {
                profit += items[i][0] - st.pop();
            }
            res = Math.max(res, profit + (long)categorySet.size() * categorySet.size());
        }
        return res;
    }

    // 自答
    public static long findMaximumElegance(int[][] items, int k) {
        if (items.length == 0) return 0;

        List<Item> itemList = new ArrayList<>(items.length);
        for (int[] item : items) {
            itemList.add(new Item(item[0], item[1]));
        }

        // Sort items in non-increasing order of profits.
        itemList.sort(Comparator.comparing(Item::getProfit, Comparator.reverseOrder())
                                .thenComparing(Item::getCategory, Comparator.reverseOrder()));

        // Select the first k items (the top k most profitable items).
        // Keep track of the items as the candidate set.
        HashMap<Long, List<Long>> map = new HashMap<>();
        long elegance = 0;
        for (int i = 0; i < items.length; i++) {
            if (i < k) {
                if(map.containsKey(itemList.get(i).getCategory())) {
                    List<Long> tmp = map.get(itemList.get(i).getCategory());
                    tmp.add(itemList.get(i).getProfit());
                    map.put(itemList.get(i).getCategory(), tmp);
                } else {
                    List<Long> tmp = new ArrayList<>();
                    tmp.add(itemList.get(i).getProfit());
                    map.put(itemList.get(i).getCategory(), tmp);
                }

                if ( i == k - 1 ) {
                    elegance = calculate(map);
                    if (map.size() == k) {
                        return elegance;
                    }
                }
            } else {
                // For the remaining n - k items sorted in non-increasing order of profits
                // try replacing an item in the candidate set using the current item
                // result total_profit + distinct_categories2
                // The replacing item should add a new category to the candidate set and should remove the item with the minimum profit that occurs more than once in the candidate set.
                Item current = itemList.get(i);
                long minProfit = Long.MAX_VALUE;
                long minProfitCategory = 0;
                for (Map.Entry<Long, List<Long>> entry : map.entrySet()) {
                    if (entry.getValue().size() > 1) {
                        for (Long profit : entry.getValue()) {
                            if (profit < minProfit) {
                                minProfit = profit;
                                minProfitCategory = entry.getKey();
                            }
                        }
                    }
                }

                if (minProfitCategory != 0) {
                    HashMap<Long, List<Long>> tmpMap = map;

                    // rm last entry
                    List<Long> entryList = tmpMap.get(minProfitCategory);
                    entryList.sort(Comparator.naturalOrder());
                    entryList.remove(0);
                    tmpMap.put(minProfitCategory, entryList);

                    // put new entry
                    if(tmpMap.containsKey(current.getCategory())) {
                        List<Long> tmp = tmpMap.get(current.getCategory());
                        tmp.add(current.getProfit());
                        tmpMap.put(current.getCategory(), tmp);
                    } else {
                        List<Long> tmp = new ArrayList<>();
                        tmp.add(current.getProfit());
                        tmpMap.put(current.getCategory(), tmp);
                    }

                    long currentElegance = calculate(tmpMap);
                    if (currentElegance > elegance) {
                        elegance = currentElegance;
                        map = tmpMap;
                    }
                }

                if (map.size() == k) {
                    return elegance;
                }
            }
        }
        return elegance;
    }

    public static long calculate (Map<Long, List<Long>> candidateMap) {
        long totalProfit = 0;
        for (Map.Entry<Long, List<Long>> entry : candidateMap.entrySet()) {
           for (Long profit : entry.getValue()) {
               totalProfit +=  profit;
           }
        }
        return (long) totalProfit + new Long(candidateMap.size()) * new Long(candidateMap.size());
    }

    static class Item {
        private Long profit;
        private Long category;

        public Long getProfit() {
            return profit;
        }
        public Long getCategory() {
            return category;
        }

        Item(int profit, int category) {
            this.profit = new Long( profit );
            this.category = new Long( category );
        }
    }

    public static void main(String[] args) {
//        System.out.println("===============test 1===============");
//        int[][] nums1 = {{1,1},{2,1},{3,1}};
//        long res1 = findMaximumElegance(nums1, 3);
//        System.out.println("nums = {{1,1},{2,1},{3,1}} ");
//        System.out.println("res = " + res1);

        System.out.println("===============test 2===============");
        int[][] nums2 = {{10,6},{2,6},{6,5},{2,6},{2,2},{7,5},{5,1}};
        long res2 = findMaximumElegance(nums2, 6);
        System.out.println( "nums = {{10,6},{2,6},{6,5},{2,6},{2,2},{7,5},{5,1}}" );
        System.out.println( "res = " + res2 );

        System.out.println("===============test 3===============");
        int[][] nums3 = {{10,6},{2,6},{6,5},{2,6},{2,2},{7,5},{5,1}};
        long res3 = findMaximumElegance(nums3, 10000);
        System.out.println( "nums = xx" );
        System.out.println( "res = " + res3 );
    }
}
