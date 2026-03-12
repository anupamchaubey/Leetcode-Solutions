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
    class Pair {
        int min;
        int max;
        int sum;

        Pair(int min, int max, int sum) {
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }

    int maxsum = 0;

    public int maxSumBST(TreeNode root) {
        post(root);
        return maxsum;
    }

    Pair post(TreeNode root) {
        if (root == null)
            return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        Pair left = post(root.left);
        Pair right = post(root.right);
        if (left.max < root.val && right.min > root.val) {
            int sum = left.sum + right.sum + root.val;
            maxsum = Math.max(maxsum, sum);
            int mini = Math.min(root.val, left.min);
            int maxi = Math.max(root.val, right.max);
            return new Pair(mini, maxi, sum);
        } else
            return new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }
}