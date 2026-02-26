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
    int count=0;
    public int pathSum(TreeNode root, int target) {
        inorder(root, target);
        return count;
    }
    void inorder(TreeNode root, long target){
        if(root==null)return;
        inorder(root.left, target);
        dfs(root, target);
        inorder(root.right, target);
    }
    void dfs(TreeNode root, long target){
        if(root==null){
            return;
        }
        if(target-root.val==0){
            count++;
        }
        dfs(root.left, target-root.val);
        dfs(root.right, target-root.val);
    }
}