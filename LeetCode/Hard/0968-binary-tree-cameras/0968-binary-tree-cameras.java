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

 // Greedy Approach
class Solution {
    int camera;
    public int minCameraCover(TreeNode root) {
        camera=0;
        postorder(root);
        if(camera==0)camera++;
        return camera;
    }
    // 0-> empty , 1-> camera , 2-> covered
    int postorder(TreeNode root){
        if(root==null)return 2;//already covered
        int left=postorder(root.left);
        int right=postorder(root.right);
        if(left==1|| right==1){
            return 2;
        }if(left==0 || right==0){
            camera++;
            return 1;
        }
        else{
            return 0;
        }
    }

}