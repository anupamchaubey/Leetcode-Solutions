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
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // here we will take ranges
    boolean valid(TreeNode root, long l, long r) {
        if (root == null)
            return true;
        if (root.val < l || root.val > r)
            return false;
        boolean left = valid(root.left, l, (long) root.val - 1);
        boolean right = valid(root.right, (long) root.val + 1, r);
        return left && right;
    }
}