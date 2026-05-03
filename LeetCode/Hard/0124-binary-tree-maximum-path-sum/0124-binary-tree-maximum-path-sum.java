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
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        path(root);
        return max;
    }
    int path(TreeNode root){
        if(root==null)return 0;
        int left=path(root.left);
        if(left<0)left=0;
        int right=path(root.right);
        if(right<0)right=0;
        max=Math.max(max, root.val+left+right);
        return root.val+ Math.max(left, right);
    }
}