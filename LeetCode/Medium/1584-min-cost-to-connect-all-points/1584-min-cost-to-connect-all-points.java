class Solution {
    int[] parent;

    int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa != pb) {
            parent[pb] = pa;
        }
    }

    class Edge {
        int u;
        int v;
        int w;

        Edge(int x, int y, int dist) {
            this.u = x;
            this.v = y;
            this.w = dist;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] p1 = points[i];
                int[] p2 = points[j];
                int dist = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
                edges.add(new Edge(i, j, dist));
            }
        }
        edges.sort((a, b) -> a.w - b.w);
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int edgesUsed = 0;
        int totalCost = 0;
        for (Edge e : edges) {
            if (find(e.u) != find(e.v)) {
                union(e.u, e.v);
                totalCost += e.w;
                edgesUsed++;
            }
            if (edgesUsed == n - 1)
                break;
        }
        return totalCost;
    }
}