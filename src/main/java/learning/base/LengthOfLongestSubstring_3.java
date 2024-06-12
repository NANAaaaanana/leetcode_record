package learning.base;

import java.util.HashSet;

/**
 * 3 无重复字符的最长子串
 */
public class LengthOfLongestSubstring_3 {
    public int lengthOfLongestSubstring(String s) {
        // get length
        int length = s.length();


        // initial param
        int maxLength = 0;
        int current = 0;

        // traversal

        for(int i = 0; i < length; i++) {
            HashSet<Character> charSet = new HashSet();
            charSet.add(s.charAt(i));

            if( i == length - 1 ) {
                current = 1;
                return maxLength > current ? maxLength : current;
            }

            for(int j = i+1; j < length; j++) {
                charSet.add(s.charAt(j));
                current = j-i+1;
                if(charSet.size() == current) {
                    maxLength = maxLength > current ? maxLength : current;
                } else {
                    break;
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("test length of longest substring");
    }
}
