package learning.daliy;

import java.util.Arrays;

public class NumRescueBoats_881_0610 {

    public static int numRescueBoats(int[] people, int limit) {
        int ans = 0;
        Arrays.sort(people);
        int light = 0, heavy = people.length - 1;
        while (light <= heavy) {
            if (people[light] + people[heavy] <= limit) {
                ++light;
            }
            --heavy;
            ++ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("===============test 1===============");
        int[] people1 = {2, 3, 4, 5, 6, 7, 8, 9};
        int result1 = numRescueBoats(people1, 9);
        System.out.println("result 1 = " + result1);
    }
}
