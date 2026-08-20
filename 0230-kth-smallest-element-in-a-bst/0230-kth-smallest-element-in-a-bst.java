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
    int cnt;
    int val;

    public int kthSmallest(TreeNode root, int k) {
        val = -1;
        cnt = k;
        inorder(root);
        return val;
    }

    void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        cnt--;
        if (cnt == 0)
            val = root.val;
        inorder(root.right);
    }
}