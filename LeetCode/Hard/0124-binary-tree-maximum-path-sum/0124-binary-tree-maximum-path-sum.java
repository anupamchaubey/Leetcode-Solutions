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
    int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        postorder(root);
        return max;
    }

    int postorder(TreeNode node) {
        if (node == null)
            return 0;
        int left = postorder(node.left);
        if (left < 0)
            left = 0;
        int right = postorder(node.right);
        if (right < 0)
            right = 0;
        max = Math.max(max, node.val + left + right);
        return node.val + Math.max(left, right);
    }
}