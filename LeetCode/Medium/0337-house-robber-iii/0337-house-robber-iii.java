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
    class Pair{
        int rob;
        int notrob;
        Pair(int rob, int notrob){
            this.rob=rob;
            this.notrob=notrob;
        }
    }
    public int rob(TreeNode root) {
        Pair p=rec(root);
        return Math.max(p.rob, p.notrob);
    }
    Pair rec(TreeNode root){
        if(root==null){
            return new Pair(0,0);
        }
        Pair left=rec(root.left);
        Pair right=rec(root.right);

        int rob=root.val+left.notrob+right.notrob;
        int notrob=Math.max(left.rob, left.notrob)+Math.max(right.rob, right.notrob);
        return new Pair(rob, notrob);
    }
}