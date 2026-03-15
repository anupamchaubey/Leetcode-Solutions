class Solution {
    public boolean canFinish(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
        }
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {

                if (!dfs(i, adj, visited, pathVisited))
                    return false;

            }
        }
        return true;
    }

    public boolean dfs(int node, List<List<Integer>> adj, boolean[] visited, boolean[] pathVisited) {
        visited[node] = true;
        pathVisited[node] = true;
        for (int i : adj.get(node)) {
            if (!visited[i]) {

                if (!dfs(i, adj, visited, pathVisited))
                    return false;

            } else {
                if (pathVisited[i])
                    return false;
            }
        }
        pathVisited[node] = false;
        return true;
    }
}