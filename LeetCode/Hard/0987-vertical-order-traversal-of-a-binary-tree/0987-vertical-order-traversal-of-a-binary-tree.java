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
        int r;
        int c;
        TreeNode root;

        Pair(int r, int c, TreeNode root) {
            this.r = r;
            this.c = c;
            this.root = root;
        }
    }

    TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> tm;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        tm = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0, root));// r, c, node

        while (!q.isEmpty()) {
            Pair p = q.poll();
            TreeNode node = p.root;
            int r = p.r;
            int c = p.c;
            tm.putIfAbsent(c, new TreeMap<>());
            tm.get(c).putIfAbsent(r, new PriorityQueue<>());
            tm.get(c).get(r).add(node.val);

            if (node.left != null) {
                q.offer(new Pair(r + 1, c - 1, node.left));
            }
            if (node.right != null) {
                q.offer(new Pair(r + 1, c + 1, node.right));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> p : tm.values()) {
            List<Integer> ls = new ArrayList<>();

            for (PriorityQueue<Integer> pq : p.values()) {
                while (!pq.isEmpty()) {
                    ls.add(pq.poll());
                }

            }
            ans.add(ls);
        }
        return ans;
    }
}