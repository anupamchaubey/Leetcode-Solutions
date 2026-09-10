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
    HashMap<TreeNode, Integer> hm;
    int cnt;

    public int averageOfSubtree(TreeNode root) {
        hm = new HashMap<>();
        subtreeNodes(root);
        cnt = 0;
        dfs(root);
        return cnt;
    }

    int subtreeNodes(TreeNode root) {
        if (root == null)
            return 0;
        int left = subtreeNodes(root.left);
        int right = subtreeNodes(root.right);
        if (hm.containsKey(root))
            return hm.get(root);
        hm.put(root, 1 + left + right);
        return 1 + left + right;
    }

    int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int val = root.val + left + right;
        if (val / hm.get(root) == root.val)
            cnt++;
        return val;
    }
}