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
    public int sumRootToLeaf(TreeNode root) {
        int sum = 0;
        List<String> ls = new ArrayList<>();
        dfs(root, "", ls);
        for (int i = 0; i < ls.size(); i++) {

            sum += Integer.parseInt(ls.get(i), 2);
        }

        return sum;
    }

    void dfs(TreeNode r1, String s, List<String> ls) {
        if (r1 == null)
            return;
        s += r1.val;
        if (r1.left == null && r1.right == null) {
            ls.add(s);
            return;
        }

        dfs(r1.left, s, ls);
        dfs(r1.right, s, ls);
    }
}