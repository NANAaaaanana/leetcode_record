package learning.daliy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1482. Minimum Number of Days to Make m Bouquets
 * You are given an integer array bloomDay, an integer m and an integer k.
 * You want to make m bouquets.
 * To make a bouquet, you need to use k adjacent flowers from the garden.
 * The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
 * Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.
 */
public class MinDays_1482_0619 {
    public static int minDays(int[] arr, int m, int k) {
        if (m > arr.length / k) {
            return -1;
        }

        int maxDay = 0;
        int minDay = 0;
        for ( int j : arr ) {
            maxDay = Math.max( maxDay, j );
            minDay = Math.min( minDay, j);
        }

        while ( minDay < maxDay ) {
            int current = ( maxDay - minDay )/2 + minDay;
            if ( currentDays(arr, current, m, k) ) {
                maxDay = current;
            } else {
                minDay = current+1;
            }
        }

        if( currentDays(arr, maxDay, m, k) ) {
            return maxDay;
        } else {
            return -1;
        }
    }

    public static boolean currentDays(int[] arr, int day, int m, int k) {
        int bouquets = 0;
        int flowers = 0;
        int length = arr.length;
        for (int i = 0; i < length && bouquets < m; i++) {
            if (arr[i] <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return bouquets >= m;
    }


    public static void main(String[] args) {
        System.out.println("===============test 1===============");
        System.out.println("result 1 = "+ minDays(new int[]{1,10,3,10,2}, 3, 1));
        System.out.println("===============test 2===============");
        System.out.println("result 2 = "+ minDays(new int[]{1,10,3,10,2}, 3, 2));
        System.out.println("===============test 3===============");
        System.out.println("result 3 = "+ minDays(new int[]{7,7,7,7,12,7,7}, 2, 3));
        System.out.println("===============test 4===============");
        System.out.println("result 3 = "+ minDays(new int[]{1000000000,1000000000}, 1, 1));
    }
}
