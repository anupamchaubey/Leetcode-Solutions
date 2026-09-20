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
    List<Integer> ls;

    public int kthSmallest(TreeNode root, int k) {
        ls = new ArrayList<>();
        inorder(root);
        return ls.get(k - 1);
    }

    void inorder(TreeNode root){
        if(root==null)return;
        inorder(root.left);
        ls.add(root.val);
        inorder(root.right);
    }
}