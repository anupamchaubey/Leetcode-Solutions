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
        height(root);
        return max;
    }
    int height(TreeNode r1){
        if(r1==null)return 0;
        int left=height(r1.left);
        int right=height(r1.right);
        if(left<0)left=0;
        if(right<0)right=0;
        max=Math.max(max, r1.val+left+right);
        return r1.val+Math.max(left, right);
    }
}