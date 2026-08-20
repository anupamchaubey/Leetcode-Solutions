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
    List<Integer> ls;

    public int[] findMode(TreeNode root) {
        ls = new ArrayList<>();
        inorder(root);
        HashMap<Integer, Integer> hm = new HashMap<>();
        int max = 0;
        for (int x : ls) {
            hm.put(x, hm.getOrDefault(x, 0) + 1);
            max = Math.max(max, hm.get(x));
        }
        ls = new ArrayList<>();
        for (int x : hm.keySet()) {
            if (hm.get(x) == max)
                ls.add(x);
        }
        int[] arr = new int[ls.size()];
        for (int i = 0; i < ls.size(); i++) {
            arr[i] = ls.get(i);
        }
        return arr;
    }

    void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        ls.add(root.val);
        inorder(root.right);
    }
}