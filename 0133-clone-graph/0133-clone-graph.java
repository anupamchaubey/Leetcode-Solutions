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
    private HashMap<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        return dfs(node);
    }

    Node dfs(Node org) {
        if (org == null)
            return org;
        if (visited.containsKey(org))
            return visited.get(org);
        Node newNode = new Node(org.val, new ArrayList<>());

        visited.put(org, newNode);
        for (Node node : org.neighbors) {
            newNode.neighbors.add(dfs(node));
        }
        return newNode;
    }
}