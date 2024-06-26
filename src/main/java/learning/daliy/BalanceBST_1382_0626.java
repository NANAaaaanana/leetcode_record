package learning.daliy;

import java.util.ArrayList;
import java.util.List;

import module.TreeNode;

/**
 * 1382. Balance a BST
 * Given the root of a binary search tree, return a balanced binary search tree with the same node values.
 * If there is more than one answer, return any of them.
 * A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.
 */
public class BalanceBST_1382_0626 {
    ArrayList <Integer> res = new ArrayList<Integer>();

    private void travesal(TreeNode cur) {
        if (cur == null) return;
        travesal(cur.left);
        res.add(cur.val);
        travesal(cur.right);
    }

    private TreeNode getTree(ArrayList <Integer> nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums.get(mid));
        root.left = getTree(nums, left, mid - 1);
        root.right = getTree(nums, mid + 1, right);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        travesal(root);
        return getTree(res, 0, res.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println("test");
    }
}
