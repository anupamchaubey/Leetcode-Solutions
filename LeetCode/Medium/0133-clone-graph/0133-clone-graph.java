/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> clone = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null)
            return node;
        return dfs(node);
    }

    Node dfs(Node node) {
        Node newNode = new Node(node.val);
        if (clone.containsKey(node))
            return clone.get(node);
        else {
            clone.put(node, newNode);
            for (Node nei : node.neighbors) {
                newNode.neighbors.add(dfs(nei));
            }
        }
        return newNode;
    }
}