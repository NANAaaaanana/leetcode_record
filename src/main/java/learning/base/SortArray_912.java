package learning.base;

import java.util.Arrays;

/**
 * 912 排序
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 * 题解
 * https://leetcode.cn/problems/sort-an-array/solutions/179489/fu-xi-ji-chu-pai-xu-suan-fa-java-by-liweiwei1419
 */
public class SortArray_912 {
    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

    // 快速排序
    public int[] sortArrayQuickSort(int[] nums) {
        // todo 暂时不想写
        return nums;
    }

    // 堆排序
    public int[] sortArrayHeapSort(int[] nums) {
        // todo 暂时不想写
        return nums;
    }

    // 归并排序
    public int[] sortArrayMergeSort(int[] nums) {
        // todo 暂时不想写
        return nums;
    }

    public static void main(String[] args) {
        System.out.println("test");
    }
}
