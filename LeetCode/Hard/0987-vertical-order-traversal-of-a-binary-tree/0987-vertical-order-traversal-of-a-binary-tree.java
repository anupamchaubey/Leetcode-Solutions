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
    TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        List<List<Integer>> ans = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            List<Integer> ls = new ArrayList<>();
            for (PriorityQueue<Integer> cols : rows.values()) {
                while (!cols.isEmpty()) {
                    ls.add(cols.poll());
                }
            }
            ans.add(ls);
        }
        return ans;

    }

    void dfs(TreeNode root, int r, int c) {
        if (root == null)
            return;
        map.putIfAbsent(c, new TreeMap());
        map.get(c).putIfAbsent(r, new PriorityQueue<>());
        map.get(c).get(r).add(root.val);
        dfs(root.left, r + 1, c - 1);
        dfs(root.right, r + 1, c + 1);
    }
}