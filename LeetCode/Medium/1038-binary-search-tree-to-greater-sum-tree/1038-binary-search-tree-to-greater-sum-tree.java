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
    int sum;
    public TreeNode bstToGst(TreeNode root) {
        sum=0;
        reverseInorder(root);
        return root;
    }
    void reverseInorder(TreeNode root){// gives descending order
        if(root==null)return;
        reverseInorder(root.right);
        sum+=root.val;
        root.val=sum;
        reverseInorder(root.left);
    }
}