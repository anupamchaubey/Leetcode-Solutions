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
/*

You are given a binary tree. You must print its nodes column by column (vertically), following three rules:

Each node has a position (row, col):

Root → (row = 0, col = 0)

Left child → (row+1, col-1)

Right child → (row+1, col+1)

Output Rules

Sort by column (left → right)

Inside a column, sort by row (top → bottom)

If row and column are same, sort by value

🔹 Why Normal BFS/DFS Is Not Enough?

Because:

Nodes can overlap in same (row, col)

We must sort them properly

Order matters

So we need:
✅ Coordinates
✅ Sorting
✅ Grouping by column

🔹 Core Idea (Standard Approach)

We use:

TreeMap<col, TreeMap<row, PriorityQueue<values>>>

Why?

Structure	Purpose
TreeMap	Keeps columns sorted
TreeMap	Keeps rows sorted
PriorityQueue	Keeps values sorted

This automatically handles all ordering rules.

*/
class Pair {
    TreeNode node;
    int r;
    int c;

    public Pair(TreeNode node, int r, int c) {
        this.node = node;
        this.r = r;
        this.c = c;
    }
}

class Solution {
    

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> tm = new TreeMap<>();
        List<List<Integer>> ans = new ArrayList<>();

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            TreeNode node = p.node;
            int r = p.r;
            int c = p.c;
            tm.putIfAbsent(c, new TreeMap<>());
            tm.get(c).putIfAbsent(r, new PriorityQueue<>());
            tm.get(c).get(r).add(node.val);

            if (node.left != null) {
                q.offer(new Pair(node.left, r + 1, c - 1));
            }

            if (node.right != null) {
                q.offer(new Pair(node.right, r + 1, c + 1));
            }
        }

        for (TreeMap<Integer, PriorityQueue<Integer>> rows : tm.values()) {
            ArrayList<Integer> list = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : rows.values()) {
                list.addAll(nodes);
            }
            ans.add(list);
        }
        return ans;
    }
}