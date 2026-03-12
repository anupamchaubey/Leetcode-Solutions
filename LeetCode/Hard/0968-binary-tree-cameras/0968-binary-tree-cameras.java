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
 // DP on tree Approach
class Solution {
    class Pair{
        int covered;
        int empty;
        int camera;
        Pair(int covered, int empty, int camera){
            this.covered=covered;
            this.empty=empty;
            this.camera=camera;
        }
    }
    public int minCameraCover(TreeNode root) {
        Pair p=postorder(root);
        return Math.min(p.covered, p.camera);
    }
    Pair postorder(TreeNode root){
        if(root==null)return new Pair(0, Integer.MAX_VALUE/2, Integer.MAX_VALUE/2);
        Pair left=postorder(root.left);
        Pair right=postorder(root.right);

        int co=Math.min(left.camera+ Math.min(right.camera, right.covered),right.camera+ Math.min(left.camera, left.covered));

        int ca=1+Math.min(left.camera, Math.min(left.covered, left.empty))+Math.min(right.camera, Math.min(right.covered, right.empty));

        int em=left.covered+right.covered;

        return new Pair(co, em, ca);
    }
}