/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void preorder(TreeNode root, HashMap<TreeNode, TreeNode> hm) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            hm.put(root.left, root);
        }
        if (root.right != null) {
            hm.put(root.right, root);
        }
        preorder(root.left, hm);
        preorder(root.right, hm);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> hm = new HashMap<>();
        preorder(root, hm);
        Set<TreeNode> visited = new HashSet<>();
        List<Integer> ls = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(target);
        visited.add(target);

        int c = 0;
        while (!q.isEmpty()) {
            if (c == k) {
                break;
            }

            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode x = q.poll();

                if (x.left != null && !visited.contains(x.left)) {
                    q.add(x.left);
                    visited.add(x.left);
                }

                if (x.right != null && !visited.contains(x.right)) {
                    q.add(x.right);
                    visited.add(x.right);
                }

                if (hm.get(x) != null && !visited.contains(hm.get(x))) {
                    q.add(hm.get(x));
                    visited.add(hm.get(x));
                }

            }
            c++;

        }
        while (!q.isEmpty()) {
            ls.add(q.poll().val);
        }
        return ls;
    }
}