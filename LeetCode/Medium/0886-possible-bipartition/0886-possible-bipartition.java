class Solution {
    int[] parent;
    int[] size;

    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py)
            return false;

        if (size[px] > size[py]) {
            parent[py] = px;
        } else if (size[py] > size[px]) {
            parent[px] = py;
        } else {
            parent[py] = px;
            size[px] += size[py];
        }
        return true;
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        // For each node u:
        // All nodes in adj[u] must be in the same group (opposite of u)

        for (int[] d : dislikes) {
            int u = d[0];
            int v = d[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for (int i = 1; i <= n; i++) {
            // All nodes in adj[u] must be in the same group (opposite of u)
            for (int j : adj.get(i)) {
                if (find(i) == find(j))
                    return false;
                union(adj.get(i).get(0), j);
            }
        }
        return true;
    }
}