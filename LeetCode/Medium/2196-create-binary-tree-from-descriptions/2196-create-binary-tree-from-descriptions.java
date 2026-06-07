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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashSet<Integer> nonroot = new HashSet<>();
        HashMap<Integer, TreeNode> hm = new HashMap<>();
        for (int[] arr : descriptions) {
            int x = arr[0];
            int y = arr[1];
            int z = arr[2];
            if (!hm.containsKey(x)) {
                hm.put(x, new TreeNode(x));
            }
            if (!hm.containsKey(y)) {
                hm.put(y, new TreeNode(y));
            }
            if (z == 1) {
                hm.get(x).left = hm.get(y);
            } else {
                hm.get(x).right = hm.get(y);
            }
            nonroot.add(y);
        }
        for (int[] arr : descriptions) {
            int x = arr[0];
            if (!nonroot.contains(x)) {
                return hm.get(x);
            }
        }
        return new TreeNode(-1);
    }
}