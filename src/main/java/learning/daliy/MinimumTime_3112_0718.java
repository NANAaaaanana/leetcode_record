package learning.daliy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 3112. 访问小时节点的最小时间
 * 给你一个二维数组 edges 表示一个 n 个点的无向图，其中 edges[i] = [ui, vi, lengthi] 表示节点 ui 和节点 vi 之间有一条需要 lengthi 单位时间通过的无向边。
 * 同时给你一个数组 disappear ，其中 disappear[i] 表示节点 i 从图中消失的时间点，在那一刻及以后，你无法再访问这个节点。
 * 注意，图有可能一开始是不连通的，两个节点之间也可能有多条边。
 * 请你返回数组 answer ，answer[i] 表示从节点 0 到节点 i 需要的 最少 单位时间。如果从节点 0 出发 无法 到达节点 i ，那么 answer[i] 为 -1 。
 */
public class MinimumTime_3112_0718 {
    public static int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<int[]>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<int[]>();
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], length = edge[2];
            adj[u].add(new int[]{v, length});
            adj[v].add(new int[]{u, length});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0});
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        answer[0] = 0;
        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int t = arr[0], u = arr[1];
            if (t != answer[u]) {
                continue;
            }
            for (int[] next : adj[u]) {
                int v = next[0], length = next[1];
                if (t + length < disappear[v] && (answer[v] == -1 || t + length < answer[v])) {
                    pq.offer(new int[]{t + length, v});
                    answer[v] = t + length;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[][] edges = {{0,1,2},{1,2,1},{0,2,4}};
        int[] test = {1,1,5};
        int[] res = minimumTime(3, edges, test);
        for(int i : res) {
            System.out.println(i);
        }
    }
}
