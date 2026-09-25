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
    public boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int lh = dfs(root.left);
        int rh = dfs(root.right);
        balanced = balanced && (Math.abs(lh - rh) <= 1);
        return balanced;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = dfs(root.left);
        int rh = dfs(root.right);
        balanced = balanced && (Math.abs(lh - rh) <= 1);
        return 1 + Math.max(lh, rh);
    }
}
