class Solution {
    int[] parent;
    int[] rank;

    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py)
            return;

        if (rank[px] > rank[py]) {
            parent[py] = px;
        } else if (rank[py] > rank[px]) {
            parent[px] = py;
        } else {
            parent[py] = px;
            rank[px]++;
        }
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        rank = new int[n + 1];
        int[] parentcheck = new int[n + 1];
        int[] edge1 = null;
        int[] edge2 = null;
        for (int e[] : edges) {
            int u = e[0];
            int v = e[1];

            if (parentcheck[v] == 0) {
                parentcheck[v] = u;
            } else {
                edge1 = new int[] { parentcheck[v], v };
                edge2 = new int[] { u, v };
                e[1] = 0;
            }

        }
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        for (int[] e : edges) {
            if (e[1] == 0)
                continue;
            int u = e[0];
            int v = e[1];
            if (find(u) == find(v)) {
                if (edge1 == null)
                    return e;
                return edge1;
            }
            union(u, v);
        }
        return edge2;
    }
}