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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (isEqual(curr, subRoot)) {
                return true;
            }
            if (curr != null) {
                stack.push(curr.left);
                stack.push(curr.right);
            }
        }
        return false;
    }

    public boolean isEqual(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        } else if (a == null || b == null || a.val != b.val) {
            return false;
        }
        return isEqual(a.left, b.left) && isEqual(a.right, b.right);
    }
}
