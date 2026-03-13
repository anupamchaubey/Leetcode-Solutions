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
    HashMap<TreeNode, TreeNode> parent = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        build(root, null);
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(target);
        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if (dist == k)
                break;
            for (int i = 0; i < size; i++) {
                TreeNode x = q.poll();

                if (x.left != null && !visited.contains(x.left)) {
                    q.offer(x.left);
                }
                if (x.right != null && !visited.contains(x.right)) {
                    q.offer(x.right);
                }
                if (parent.get(x) != null && !visited.contains(parent.get(x))) {
                    q.offer(parent.get(x));
                }
                visited.add(x);
            }
            dist++;
        }
        List<Integer> ls = new ArrayList<>();
        while (!q.isEmpty()) {
            ls.add(q.poll().val);
        }
        return ls;
    }

    void build(TreeNode root, TreeNode prev) {
        if (root == null)
            return;
        parent.put(root, prev);
        build(root.left, root);
        build(root.right, root);

    }
}