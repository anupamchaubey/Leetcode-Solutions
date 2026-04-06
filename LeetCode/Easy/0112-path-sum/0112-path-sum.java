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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)return false;
        return dfs(root, targetSum, 0);
    }
    boolean dfs(TreeNode root, int target, int sum){
        if(root==null){
            return false;
        }
        if(root.left==null && root.right==null){
            return sum+root.val==target;
        }
        
        boolean left=dfs(root.left, target, sum+root.val);
        boolean right=dfs(root.right, target, sum+root.val);
        return left||right;
    }
}