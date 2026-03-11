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
    TreeNode node1 = null, node2 = null;
    List<Integer> ls = new ArrayList<>();

    public void recoverTree(TreeNode root) {

        inorder(root, -1, -1);
        List<Integer> arr = new ArrayList<>(ls);
        Collections.sort(arr);
        int n1 = -1, n2 = -1;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) != ls.get(i)) {
                if (n1 != -1) {
                    n2 = ls.get(i);
                    break;
                } else
                    n1 = ls.get(i);
            }
        }
        inorder(root, n1, n2);
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;

    }

    void inorder(TreeNode root, int x, int y) {
        if (root == null)
            return;
        inorder(root.left, x, y);
        ls.add(root.val);
        if (root.val == x)
            node1 = root;
        if (root.val == y)
            node2 = root;
        inorder(root.right, x, y);
    }

}