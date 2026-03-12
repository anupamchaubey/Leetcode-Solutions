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
    int maxsum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        postorder(root);
        return maxsum;
    }

    int postorder(TreeNode root) {
        if (root == null)
            return 0;
        int left = Math.max(0, postorder(root.left));
        int right = Math.max(0, postorder(root.right));

        int sum = root.val + left + right;

        maxsum = Math.max(maxsum, sum);

        return root.val + Math.max(left, right);
    }
}