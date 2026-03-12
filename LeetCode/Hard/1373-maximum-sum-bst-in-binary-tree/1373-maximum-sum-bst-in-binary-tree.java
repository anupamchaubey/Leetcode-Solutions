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
        int min, max, sum;
        boolean isBST;

        //max , min
        Pair(int max, int min, int sum, boolean isBST) {
            this.max = max;
            this.min = min;
            this.sum = sum;
            this.isBST = isBST;
        }
    }

    int maxsum;

    public int maxSumBST(TreeNode root) {
        maxsum = 0;
        post(root);
        return maxsum;
    }

    Pair post(TreeNode root) {
        if (root == null) {
            return new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, true);
        }
        Pair left = post(root.left);
        Pair right = post(root.right);
        if (left.isBST && right.isBST && left.max < root.val && right.min > root.val) {
            int sum = left.sum + right.sum + root.val;
            maxsum = Math.max(maxsum, sum);
            int mini = Math.min(left.min, root.val);
            int maxi = Math.max(right.max, root.val);
            return new Pair(maxi, mini, sum, true);
        } else
            return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, false);
    }
}