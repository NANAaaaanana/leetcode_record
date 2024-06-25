package learning.daliy;

import module.TreeNode;

/**
 * 1038 Binary Search Tree to Greater Sum Tree
 */
public class BstToGst_1038_0625 {

    private int s = 0;

    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.right); // right child
        s += node.val;
        node.val = s; //  s is the nums sum >= node.val
        dfs(node.left); // left child
    }

    public static void main(String[] args) {
        System.out.println("test");
    }
}
