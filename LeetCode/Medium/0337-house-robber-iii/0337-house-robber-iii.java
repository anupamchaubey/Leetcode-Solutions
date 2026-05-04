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
        int notRob;
        Pair(int rob, int notRob){
            this.rob=rob;
            this.notRob=notRob;
        }
    }
    public int rob(TreeNode root) {
        Pair p=dfs(root);
        return Math.max(p.rob, p.notRob);
    }
    Pair dfs(TreeNode root){
        if(root==null){
            return new Pair(0, 0);
        }
        Pair left=dfs(root.left);
        Pair right=dfs(root.right);

        int rob=root.val+left.notRob+right.notRob;
        int notRob=Math.max(left.rob, left.notRob)+Math.max(right.rob, right.notRob);

        return new Pair(rob, notRob);
    }
}