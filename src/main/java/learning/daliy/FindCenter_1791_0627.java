package learning.daliy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.SortedMap;

/**
 * 1791. Find Center of Star Graph
 * There is an undirected star graph consisting of n nodes labeled from 1 to n.
 * A star graph is a graph where there is one center node and exactly n - 1 edges that connect the center node with every other node.
 * You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates that there is an edge between the nodes ui and vi.
 * Return the center of the given star graph.
 */
public class FindCenter_1791_0627 {


    public int findCenter0(int[][] edges) {
        int a = edges[0][0];
        int b = edges[0][1];

        if(a == edges[1][0] || a == edges[1][1])
            return a;
        else
            return b;
    }

    public int findCenter(int[][] edges) {
        int[] nums = new int [100001];
        for (int i = 0; i < edges.length; i++) {
            nums[edges[i][0]]++;
            nums[edges[i][1]]++;
        }

        int max = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                result = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("test");
    }
}
