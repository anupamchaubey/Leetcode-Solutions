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
    int idx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, inorder.length - 1);
    }

    TreeNode helper(int[] preorder, int[] inorder, int st, int en) {
        if (st > en)
            return null;
        int rootval = preorder[idx++];
        TreeNode root = new TreeNode(rootval);
        int index = -1;
        for (int i = st; i <= en; i++) {
            if (inorder[i] == rootval) {
                index = i;
                break;
            }
        }
        root.left = helper(preorder, inorder, st, index - 1);
        root.right = helper(preorder, inorder, index + 1, en);

        return root;

    }
}