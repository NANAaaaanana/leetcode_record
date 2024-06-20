package learning.daliy;

import java.util.Arrays;

/**
 * 1552. Magnetic Force Between Two Balls
 * In the universe Earth C-137, Rick discovered a special form of magnetic force between two balls if they are put in his new invented basket.
 * Rick has n empty baskets, the ith basket is at position[i], Morty has m balls and needs to distribute the balls into the baskets such that the minimum magnetic force between any two balls is maximum.
 * Rick stated that magnetic force between two different balls at positions x and y is |x - y|.
 * Given the integer array position and the integer m. Return the required force.
 */
public class MaxDistance_1552_0620 {
    public int maxDistance(int[] position, int m) {

        Arrays.sort(position);
        int lo = 1;
        int hi = (position[position.length-1]-position[0])/(m-1);
        int ans = 1;
        while(lo<=hi)
        {
            int mid = lo+(hi-lo)/2;
            if(canWePlace(position, mid, m))
            {
                ans = mid;
                lo=mid+1;
            }
            else
            {
                hi = mid-1;
            }
        }
        return ans;
    }

    private boolean canWePlace(int[] arr, int dist, int cows)
    {
        int cntCows=1;
        int last = arr[0];
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]-last>=dist)
            {
                cntCows++;
                last = arr[i];
            }
            if(cntCows>=cows)
            {
                return true;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        System.out.println("test");
    }
}
