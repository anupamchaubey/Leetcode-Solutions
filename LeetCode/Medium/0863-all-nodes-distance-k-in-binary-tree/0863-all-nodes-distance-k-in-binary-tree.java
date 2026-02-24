/*
You are given:

A binary tree

A target node

An integer k

You must return all node values that are exactly k edges away from the target node.

Distance = number of edges.

If k = 2, find all nodes that are 2 steps away from target.

This can be:

Downward (children)

Upward (parent)

Then downward again

But in a binary tree, we don’t have parent pointers ❌

So first, we must build them.

.

🔹 Key Idea (Very Important)

We will convert the tree into a graph:

Each node can move to:

left child
right child
parent

Then we run BFS from target.

This becomes a shortest distance problem in a graph.

🔹 Final Algorithm
1️⃣ Build parent map using DFS
2️⃣ BFS from target
3️⃣ Stop when distance == k
4️⃣ Collect values

Time Complexity: O(N)
Space Complexity: O(N)


 */

class Solution {
    HashMap<TreeNode, TreeNode> map=new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        buildParent(root, null);
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.add(target);

        int dist = 0;
        while (!q.isEmpty()) {

            if (dist == k) {
                List<Integer> ans = new ArrayList<>();
                for (TreeNode n : q) {
                    ans.add(n.val);
                }
                return ans;
            }
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                // Go left
                if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    q.offer(curr.left);
                }
                // Go right
                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    q.offer(curr.right);
                }
                // Go parent
                TreeNode par = map.get(curr);
                if (par != null && !visited.contains(par)) {
                    visited.add(par);
                    q.offer(par);
                }
            }
            dist++;
        }
        return new ArrayList<>();
    }

    void buildParent(TreeNode node, TreeNode parent) {
        if (node == null)
            return;

        map.put(node, parent);
        buildParent(node.left, node);
        buildParent(node.right, node);
    }
}