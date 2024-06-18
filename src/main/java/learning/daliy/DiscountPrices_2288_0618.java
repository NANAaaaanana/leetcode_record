package learning.daliy;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 2288. 价格减免
 * 句子 是由若干个单词组成的字符串，单词之间用单个空格分隔，其中每个单词可以包含数字、小写字母、和美元符号 '$' 。如果单词的形式为美元符号后跟着一个非负实数，那么这个单词就表示一个 价格 。
 * 例如 "$100"、"$23" 和 "$6" 表示价格，而 "100"、"$" 和 "$1e5 不是。
 * 给你一个字符串 sentence 表示一个句子和一个整数 discount 。对于每个表示价格的单词，都在价格的基础上减免 discount% ，并 更新 该单词到句子中。所有更新后的价格应该表示为一个 恰好保留小数点后两位 的数字。
 * 返回表示修改后句子的字符串。
 * 注意：所有价格 最多 为  10 位数字。
 */
public class DiscountPrices_2288_0618 {
    public static String discountPrices(String sentence, int discount) {
        StringBuffer resultSb = new StringBuffer();
        int i = 0;
        while (i < sentence.length()) {
            if (sentence.charAt(i) == ' ' && i < sentence.length() - 1 && sentence.charAt(i + 1) == '$' ||
                sentence.charAt(i) == '$' && i == 0 ) {
                int j = i;
                if (sentence.charAt(i) == ' ' && i < sentence.length() - 1 && sentence.charAt(i + 1) == '$' ) {
                    resultSb.append(sentence.charAt(i));
                    resultSb.append(sentence.charAt(i + 1));
                    j = i + 2;
                }
                if( sentence.charAt(i) == '$' && i == 0) {
                    resultSb.append(sentence.charAt(i));
                    j = i + 1;
                }
                StringBuffer sb = new StringBuffer();
                while (j < sentence.length() && isDigital(sentence.charAt(j))) {
                    sb.append(sentence.charAt(j));
                    j++;
                }

                if (j < sentence.length() && j > i + 1 && sentence.charAt(j) != ' ') {
                    resultSb.append(sb);
                    i = j;
                    continue;
                }

                if (sb.length() > 0) {
                    resultSb.append(discount(sb.toString(), discount));
                }
                i = j;
            } else {
                resultSb.append(sentence.charAt(i));
                i++;
            }


        }

        return resultSb.toString();
    }


    public static String discount(String price, int discount) {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        double result = Double.parseDouble(price) * (100-discount) / 100;
        return decimalFormat.format(result);
    }

    public static boolean isDigital(Character ch) {
        if(ch == ' ') {
            return false;
        }
        if (ch >= '0' && ch <= '9') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("===============test 1===============");
        System.out.println("sentence = there are $1 $2 and 5$candies in the shop");
        System.out.println("result 1 = " + discountPrices("there are $1 $2 and 5$candies in the shop", 50));

        System.out.println("===============test 2===============");
        System.out.println("sentence = 1 2 $3 4 $5 $6 7 8$ $9 $10$");
        System.out.println("result 2 = " + discountPrices("1 2 $3 4 $5 $6 7 8$ $9 $10$", 0));

        System.out.println("===============test 3===============");
        System.out.println("sentence = $2$3 $10 $100 $1 200 $33 33$ $$ $99 $99999 $9999999999");
        System.out.println("result 3 = " + discountPrices("$2$3 $10 $100 $1 200 $33 33$ $$ $99 $99999 $9999999999", 0));
    }
}
