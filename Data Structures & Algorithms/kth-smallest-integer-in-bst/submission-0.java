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
    public int kthSmallest(TreeNode root, int k) {
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        int ret = -1;

        for (int i = 0; i < k; i++) {
            TreeNode curr = list.remove(0);
            if (curr == null) {
                i--;
            } else {
                ret = curr.val;
            }
        }
        return ret;
    }

    public void dfs(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root);
        dfs(root.right, list);
    }
}
