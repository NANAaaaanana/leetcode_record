package topic.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 274. H Index
 *
 * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.
 * According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.
 */
public class HIndex_274 {

    public static int hIndex(int[] citations) {

        // todo
//        int h = citations.length;
//        int maxi=0;
//        Arrays.sort(citations);
//
//        for ( int i = 0; i < citations.length; i++ ) {
//            if (citations[i] >= h-i){
//                maxi = Math.max(maxi,h-i);
//            }
//        }
//        return maxi;
        return 0;
    }

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(hIndex(citations));
    }
}
