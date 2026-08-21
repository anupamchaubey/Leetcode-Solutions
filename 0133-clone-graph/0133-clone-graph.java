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
    HashMap<Node, Node> visited;

    public Node cloneGraph(Node node) {
        if (node == null)
            return node;
        visited = new HashMap<>();
        return dfs(node);
    }

    Node dfs(Node node) {
        if (visited.containsKey(node))
            return visited.get(node);
        else {
            Node newNode = new Node(node.val);
            visited.put(node, newNode);
            for (Node n : node.neighbors) {
                Node x = dfs(n);
                newNode.neighbors.add(x);
            }
            return newNode;
        }
    }
}