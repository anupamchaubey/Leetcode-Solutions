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
    int camera=0;
    public int minCameraCover(TreeNode root) {
        if(helper(root)==0)camera++;
        return camera;
    }
    // 0 -> blank , 1 -> camera , 2-> covered
    int helper(TreeNode root){
        if(root==null)return 2;
        int left=helper(root.left);
        int right=helper(root.right);
        if(left==0 || right==0){
            camera++;
            return 1;
        }
        else if(left==1|| right==1){
            return 2;
        }else{
            return 0;
        }
    }
}