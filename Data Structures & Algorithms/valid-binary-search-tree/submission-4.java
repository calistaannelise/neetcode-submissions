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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean dfs(TreeNode root, int lo, int hi) {
        if (root == null) {
            return true;
        }
        return lo < root.val && root.val < hi && dfs(root.left, lo, root.val) && dfs(root.right, root.val, hi);
    }
}
