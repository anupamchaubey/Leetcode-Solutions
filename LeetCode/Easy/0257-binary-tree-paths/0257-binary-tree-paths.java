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
    List<String> ans;

    public List<String> binaryTreePaths(TreeNode root) {
        ans = new ArrayList<>();
        dfs(root, new StringBuilder());
        return ans;
    }

    void dfs(TreeNode root, StringBuilder sb) {

        if (root == null)
            return;

        int len = sb.length();

        sb.append(root.val);
        if (root.left == null && root.right == null) {
            ans.add(sb.toString());
        } else {
            sb.append("->");
            dfs(root.left, sb);
            dfs(root.right, sb);
        }
        sb.setLength(len);

    }
}