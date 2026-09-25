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
        List<TreeNode> list = new ArrayList<>();

        dfs(root, list);
        if (list.size() == 0) {
            return true;
        }
        int idx = 0;
        while (idx < list.size() && list.get(idx) == null) {
            idx++;
        }

        for (int i = 0; i < list.size(); i++) {
            TreeNode curr = list.get(i);
            if (curr == null) {
                System.out.print("null, ");
            } else {
                System.out.print(curr.val + ", ");
            }
        }
        int prev = list.get(idx).val;
        for (int i = idx + 1; i < list.size(); i++) {
            TreeNode curr = list.get(i);
            if (curr != null) {
                int val = curr.val;
                System.out.println(prev + " " + val);
                if (prev >= val) {
                    return false;
                }
                prev = val;
            }
        }
        return true;
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
