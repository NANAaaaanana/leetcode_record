package learning.daliy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 2748. 美丽下标对的数目
 * 给你一个下标从 0 开始的整数数组 nums 。
 * 如果下标对 i、j 满足 0 ≤ i < j < nums.length ，如果 nums[i] 的 第一个数字 和 nums[j] 的 最后一个数字 互质 ，则认为 nums[i] 和 nums[j] 是一组 美丽下标对 。
 * 返回 nums 中 美丽下标对 的总数目。
 * 对于两个整数 x 和 y ，如果不存在大于 1 的整数可以整除它们，则认为 x 和 y 互质 。
 * 换而言之，如果 gcd(x, y) == 1 ，则认为 x 和 y 互质，其中 gcd(x, y) 是 x 和 y 的 最大公因数 。
 */
public class CountBeautifulPairs_2748_0620 {


    public static int countBeautifulPairs0(int[] nums) {
        int res = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] >= 10) {
                nums[i] /= 10;
            }
            for (int j = i + 1; j < n; j++) {
                if (gcd0(nums[i], nums[j] % 10) == 1) {
                    res++;
                }
            }
        }
        return res;
    }

    public static int gcd0(int a, int b) {
        return b == 0 ? a : gcd0(b, a % b);
    }


    public static int countBeautifulPairs(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            int head = nums[i];
            while(head >= 10) {
                head /= 10;
            }
            for(int j = i+1; j < nums.length; j++) {
                int tail = nums[j] % 10;
                if(gcd(head, tail) == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int gcd(int p, int q) {
        if(p == 0 && q == 0) {
            return 1;
        }

        if(p == q) {
            return q;
        }

        if(p > q) {
            return gcd(p - q, q);
        } else {
            return gcd(p, q-p);
        }
    }

    public static void main(String[] args) {
        System.out.println("===============test 1===============");
        System.out.println("result 1 = "+ countBeautifulPairs0(new int[]{2,5,1,4}));
        System.out.println("===============test 2===============");
        System.out.println("result 2 = "+ countBeautifulPairs0(new int[]{11,21,12}));

        System.out.println("===============test 3===============");
        System.out.println("result 3 = "+ countBeautifulPairs0(new int[]{24,17,34}));
    }
}
