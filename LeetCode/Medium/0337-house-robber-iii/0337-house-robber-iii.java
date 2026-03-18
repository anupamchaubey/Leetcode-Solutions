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
        int not;
        Pair(int rob, int not){
            this.rob=rob;
            this.not=not;
        }
    }
    public int rob(TreeNode root) {
        Pair p=postorder(root);
        return Math.max(p.rob, p.not);
    }
    Pair postorder(TreeNode root){
        if(root==null)return new Pair(0, 0);
        Pair left=postorder(root.left);
        Pair right=postorder(root.right);
        int rob=root.val+left.not+right.not;
        int not=Math.max(left.rob, left.not)+Math.max(right.rob, right.not);
        return new Pair(rob, not);
    }
}