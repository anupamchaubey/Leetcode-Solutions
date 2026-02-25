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
    class Pair {
        TreeNode node;
        boolean flag;

        public Pair(TreeNode node, boolean flag) {
            this.node = node;
            this.flag = flag;
        }
    }

    HashMap<Pair, Long> memo = new HashMap<>();

    public int rob(TreeNode root) {

        boolean prev = false;
        long max = rec(root, prev);
        return (int) max;
    }

    long rec(TreeNode root, boolean prev) {
        if (root == null)
            return 0;
        Pair key = new Pair(root, prev);
        if (memo.containsKey(key))
            return memo.get(key);
        long ans;
        if (prev) {
            //cannot rob
            long a = rec(root.left, false);
            long b = rec(root.right, false);
            ans = a + b;
        } else {
            //can rob
            long take = root.val + rec(root.left, true) + rec(root.right, true);
            long nontake = rec(root.left, false) + rec(root.right, false);
            ans = Math.max(take, nontake);
        }
        memo.put(key, ans);
        return ans;

    }
}