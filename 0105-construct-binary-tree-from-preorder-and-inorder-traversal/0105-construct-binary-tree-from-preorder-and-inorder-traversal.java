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
    int idx;
    HashMap<Integer, Integer> hm;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        idx = 0;
        hm = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }
        return dfs(preorder, 0, inorder.length - 1);
    }

    TreeNode dfs(int[] preorder, int st, int en) {
        if (st > en)
            return null;
        int val = preorder[idx++];
        TreeNode root = new TreeNode(val);
        root.left = dfs(preorder, st, hm.get(val) - 1);
        root.right = dfs(preorder, hm.get(val) + 1, en);
        return root;
    }
}