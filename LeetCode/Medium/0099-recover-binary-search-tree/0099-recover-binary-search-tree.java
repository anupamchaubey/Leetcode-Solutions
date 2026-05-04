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

/*

In a valid BST, an inorder traversal visits nodes in ascending order. If two nodes are swapped, this sorted property is broken.

The First Mistake: This is the first time we see the order break. The incorrect node is the prev node (the larger value that appeared too early).

The Second Mistake: This is the last time we see the order break. The incorrect node is the current node (the smaller value that appeared too late).
*/
class Solution {
    TreeNode first=null;
    TreeNode second=null;
    TreeNode prev=null;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
    }
    void inorder(TreeNode root){
        if(root==null)return;
        inorder(root.left);
        if(prev!=null && prev.val>=root.val){
            if(first==null){
                first=prev;
            }
            second=root;
        }
        prev=root;
        inorder(root.right);
    }
}