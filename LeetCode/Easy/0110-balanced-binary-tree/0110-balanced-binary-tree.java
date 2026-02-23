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
    public boolean isBalanced(TreeNode r1) {
        if(r1==null)return true;
        int x=Math.abs(height(r1.left)- height(r1.right));
        if(x>1)return false;
        return isBalanced(r1.left) && isBalanced(r1.right);
    }
    int height(TreeNode r1){
        if(r1==null)return 0;
        return 1+Math.max(height(r1.left), height(r1.right));
    }
}