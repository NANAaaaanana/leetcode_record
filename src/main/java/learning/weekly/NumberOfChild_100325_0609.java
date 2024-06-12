package learning.weekly;

/**
 * 周赛 401
 * 100325 找出k秒后拿着球的孩子
 *
 * 给你两个 正整数 n 和 k。有 n 个编号从 0 到 n - 1 的孩子按顺序从左到右站成一队。
 * 最初，编号为 0 的孩子拿着一个球，并且向右传球。每过一秒，拿着球的孩子就会将球传给他旁边的孩子。一旦球到达队列的 任一端 ，即编号为 0 的孩子或编号为 n - 1 的孩子处，传球方向就会 反转 。
 * 返回 k 秒后接到球的孩子的编号。
 */
public class NumberOfChild_100325_0609 {

    public static int numberOfChild(int n, int k) {

        if(n == 0 || k == 0 || n == 1){
            return 0;
        }

        int div = k/(n-1);
        int mod = k%(n-1);

        if(div % 2 == 0) {
            return mod;
        } else {
            return n-1-mod;
        }
    }

    public static void main(String[] args) {
        System.out.println("===============test 1===============");
        System.out.println("n = 3, k = 5");
        System.out.println("resp = " + numberOfChild(3, 5));
        System.out.println("===============test 2===============");
        System.out.println("n = 5, k = 6");
        System.out.println("resp = " + numberOfChild(5, 6));
    }
}
