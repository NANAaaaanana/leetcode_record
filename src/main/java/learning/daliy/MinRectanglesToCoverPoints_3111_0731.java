package learning.daliy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 3111. 覆盖所有点的最小矩形
 * 给你一个二维整数数组 point ，其中 points[i] = [xi, yi] 表示二维平面内的一个点。同时给你一个整数 w 。你需要用矩形 覆盖所有 点。
 * 每个矩形的左下角在某个点 (x1, 0) 处，且右上角在某个点 (x2, y2) 处，其中 x1 <= x2 且 y2 >= 0 ，同时对于每个矩形都 必须 满足 x2 - x1 <= w 。
 * 如果一个点在矩形内或者在边上，我们说这个点被矩形覆盖了。
 * 请你在确保每个点都 至少 被一个矩形覆盖的前提下，最少 需要多少个矩形。
 * 注意：一个点可以被多个矩形覆盖。
 */
public class MinRectanglesToCoverPoints_3111_0731 {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points, Comparator.comparingInt(p -> p[0]));
        int ans = 0;
        int x2 = -1;
        for (int[] p : points) {
            if (p[0] > x2) {
                ans++;
                x2 = p[0] + w;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[][] points = new int[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}};
        int w = 2;
        System.out.println(new MinRectanglesToCoverPoints_3111_0731().minRectanglesToCoverPoints(points, w));
    }
}
