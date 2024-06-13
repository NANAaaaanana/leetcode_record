package learning.daliy;

import java.util.Arrays;

/**
 * 2037 Minimum Number Of Moves To Seat Everyone
 * There are n seats and n students in a room. You are given an array seats of length n, where seats[i] is the position of the ith seat. You are also given the array students of length n, where students[j] is the position of the jth student.
 * You may perform the following move any number of times:
 * Increase or decrease the position of the ith student by 1 (i.e., moving the ith student from position x to x + 1 or x - 1)
 * Return the minimum number of moves required to move each student to a seat such that no two students are in the same seat.
 * Note that there may be multiple seats or students in the same position at the beginning.
 */
public class MinMovesToSeat_2037_0613 {

    public static int minMovesToSeat(int[] seats, int[] students) {
        if (seats == null || students == null || seats.length != students.length) {
            return 0;
        }

        Arrays.sort(seats);
        Arrays.sort(students);
        int count = 0;
        for (int i = 0; i < seats.length; i++) {
            count += Math.abs(students[i] - seats[i]);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("===============test 1===============");
        int[] nums1_1 = {3,2,1,4};
        int[] nums2_1 = {1,2,3,4};
        System.out.println("result 1 = "+ minMovesToSeat(nums1_1, nums2_1));

        System.out.println("===============test 2===============");
        int[] nums1_2 = {4,1,5,9};
        int[] nums2_2 = {1,3,2,6};
        System.out.println("result 2 = "+ minMovesToSeat(nums1_2, nums2_2));
    }
}
