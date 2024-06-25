package learning.daliy;

import java.util.ArrayList;
import java.util.List;

/**
 * 2732 找到矩阵中的好子集
 * 给你一个下标从 0 开始大小为 m x n 的二进制矩阵 grid 。
 * 从原矩阵中选出若干行构成一个行的 非空 子集，如果子集中任何一列的和至多为子集大小的一半，那么我们称这个子集是 好子集。
 * 更正式的，如果选出来的行子集大小（即行的数量）为 k，那么每一列的和至多为 floor(k / 2) 。
 * 请你返回一个整数数组，它包含好子集的行下标，请你将其 升序 返回。
 * 如果有多个好子集，你可以返回任意一个。如果没有好子集，请你返回一个空数组。
 * 一个矩阵 grid 的行 子集 ，是删除 grid 中某些（也可能不删除）行后，剩余行构成的元素集合。
 */
public class GoodSubsetOfBinaryMatrix_2732_0625 {
    public static List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int index = -1;
        for (int i = 0; i < m; i++) {
            double maxTarget =  Math.floor( (i + 1)/2);
            double sum = 0;
            for (int j = 0; j < n; j++) {
                sum += grid[i][j];
            }

            if (sum > maxTarget) {
                continue;
            }
            index = i;
            break;
        }

        List<Integer> res = new ArrayList<>();
        if(index == -1) {
            return res;
        }

        for (int i = 0; i <= index; i++) {
            res.add(i);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("===============test 1===============");
        int[][] grid = {{1,0,0,1,0},{1,0,1,0,1},{0,0,0,0,1},{1,0,1,1,1}};
        List<Integer> res = goodSubsetofBinaryMatrix(grid);
        StringBuffer sb = new StringBuffer();
        sb.append("[ ");
        for (Integer integer : res) {
            sb.append(integer + " ");
        }
        sb.append("]");
        System.out.println("result = " + sb);
    }
}
