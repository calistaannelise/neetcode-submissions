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
    public int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        
        int curr = root.val;
        max = Math.max(max, curr + left + right);
        if (curr + left <= curr && curr + right <= curr) {
            max = Math.max(max, curr);
            return curr;
        } else if (curr + left > curr && curr + left > curr + right) {
            max = Math.max(max, curr + left);
            return curr + left;
        } else {
            max = Math.max(max, curr + right);
            return curr + right;
        }
    }
}
