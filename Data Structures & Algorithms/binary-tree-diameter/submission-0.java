/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int ret = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        int temp = dfs(root);
        return ret;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = dfs(root.left);
        int rh = dfs(root.right);
        ret = Math.max(rh + lh, ret);
        return 1 + Math.max(lh, rh);
    }
}
