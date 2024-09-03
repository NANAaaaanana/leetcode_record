package learning.daliy;

import java.util.ArrayList;
import java.util.List;

/**
 * 1945. Sum of Digits of String After Convert
 *  You are given a string s consisting of lowercase English letters, and an integer k.
 *  First, convert s into an integer by replacing each letter with its position in the alphabet (i.e., replace 'a' with 1, 'b' with 2, ..., 'z' with 26). Then, transform the integer by replacing it with the sum of its digits. Repeat the transform operation k times in total.
 *  For example, if s = "zbax" and k = 2, then the resulting integer would be 8 by the following operations:
 *  Convert: "zbax" ➝ "(26)(2)(1)(24)" ➝ "262124" ➝ 262124
 *  Transform #1: 262124 ➝ 2 + 6 + 2 + 1 + 2 + 4 ➝ 17
 *  Transform #2: 17 ➝ 1 + 7 ➝ 8
 *  Return the resulting integer after performing the operations described above.
 */
public class SumOfDigitsOfStringAfterConvert_1945_0903 {
    public int getLucky(String s, int k) {
        int sum = 0;
        for(char c : s.toCharArray()) {
            int i = c - 'a' + 1;
            sum += i % 10 + i / 10;
        }

        if ( k == 1 ) {
            return sum;
        } else {
            while ( k > 1 ) {
                sum = getLucky(sum);
                k--;
            }
        }
        return sum;
    }

    public int getLucky( int n ) {
        int sum = 0;
        while ( n > 0 ) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        SumOfDigitsOfStringAfterConvert_1945_0903 test = new SumOfDigitsOfStringAfterConvert_1945_0903();
        System.out.println(test.getLucky("zbax", 2));
    }
}
