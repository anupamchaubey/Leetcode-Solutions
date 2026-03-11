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
    HashSet<Integer> hs= new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        return inorder(root, k);
    }
    boolean inorder(TreeNode root, int k){
        if(root==null)return false;
        boolean x=inorder(root.left, k);
        if(hs.contains(k-root.val))return true;
        hs.add(root.val);
        boolean y=inorder(root.right, k);
        return x||y;
    }
}