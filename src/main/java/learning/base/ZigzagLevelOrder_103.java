package learning.base;

import java.util.List;

/**
 * 103 二叉树的锯齿形层遍历
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class ZigzagLevelOrder_103 {

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         // todo 没什么思路 先不写
         return  null;
    }

    public static void main(String[] args) {
        System.out.println("test");
    }

}
