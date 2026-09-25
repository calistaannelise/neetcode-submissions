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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> ret = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int prev = -101;

        while (!q.isEmpty()) {
            int n = q.size();
            int last = -101;
            TreeNode curr = null;
            for (int i = 0; i < n; i++) {
                curr = q.remove();
                if (curr != null) {
                    q.add(curr.left);
                    q.add(curr.right);
                    last = curr.val;
                }
            }
            if (last != -101) {
                ret.add(last);
            }
        }
        return ret;
    }
}
