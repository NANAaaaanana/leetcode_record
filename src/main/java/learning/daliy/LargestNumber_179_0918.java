package learning.daliy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 179. Largest Number
 * Given a list of non negative integers, arrange them such that they form the largest number.
 */
public class LargestNumber_179_0918 {
    public String largestNumber(int[] nums) {
        List<String> list = Arrays.stream(nums).mapToObj(String::valueOf).sorted((o1, o2) -> (o1 + o2).compareTo(o2 + o1)).collect(Collectors.toList());
        if (list.stream().allMatch(str -> str.equals("0"))) {return "0";}

        StringBuffer sb = new StringBuffer();
        for (int i = list.size() - 1; i > -1; i--) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }



    public static void main(String[] args) {
        System.out.println("===============test 1===============");
        System.out.println("result 1 = "+ new LargestNumber_179_0918().largestNumber(new int[]{3,30,34,5,9}));
    }
}
