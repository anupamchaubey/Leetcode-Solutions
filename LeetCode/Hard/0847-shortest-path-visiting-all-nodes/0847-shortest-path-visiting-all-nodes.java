class Solution {
    class Pair {
        int node;
        int time;
        int bit;

        Pair(int node, int time, int bit) {
            this.node = node;
            this.time = time;
            this.bit = bit;
        }
    }

    int V;

    public int shortestPathLength(int[][] graph) {
        Queue<Pair> q = new LinkedList<>();
        V = graph.length;
        boolean[][] visited = new boolean[V][(1 << V)];
        for (int i = 0; i < V; i++) {
            int bit = (1 << i);
            visited[i][bit] = true;
            q.offer(new Pair(i, 0, bit));
        }

        while (!q.isEmpty()) {
            Pair X = q.poll();
            int node = X.node;
            int t = X.time;
            int b = X.bit;
            if (check(b))
                return t;

            for (int v : graph[node]) {

                int bit = b | (1 << v);
                if (!visited[v][bit]) {
                    visited[v][bit] = true;
                    Pair p = new Pair(v, t + 1, bit);
                    q.offer(p);
                }

            }
        }
        return -1;
    }

    boolean check(int bit) {
        int c = 0;
        while (bit > 0) {
            if ((bit & 1) == 1)
                c++;
            bit = bit >> 1;
        }
        if (c == V)
            return true;
        else
            return false;
    }
}