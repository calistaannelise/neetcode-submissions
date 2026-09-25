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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{p, q});

        while (!stack.isEmpty()) {
            TreeNode[] tn = stack.pop();
            TreeNode a = tn[0];
            TreeNode b = tn[1];
            
            if (a == null && b == null) {
                continue;
            } else if (a == null || b == null) {
                return false;
            } else if (a.val != b.val) {
                return false;
            }

            stack.push(new TreeNode[]{a.left, b.left});
            stack.push(new TreeNode[]{a.right, b.right});
        }
        return true;
    }
}
