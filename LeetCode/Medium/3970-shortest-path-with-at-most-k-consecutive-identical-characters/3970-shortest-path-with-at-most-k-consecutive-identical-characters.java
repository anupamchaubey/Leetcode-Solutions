class Pair {
    int to;
    int wt;
    int ch;

    Pair(int to, int wt, int ch) {
        this.to = to;
        this.wt = wt;
        this.ch = ch;
    }
}

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] e = edges[i];
            int u = e[0];
            int v = e[1];
            int w = e[2];
            adj.get(u).add(new Pair(v, w, 1));
        }
        int[][] dist = new int[n][k + 1];
        for (int[] arr : dist) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        dist[0][1] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.wt, b.wt));

        pq.offer(new Pair(0, 0, 1));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int pu = p.to;
            int pw = p.wt;
            int pc = p.ch;

            if (pw > dist[pu][pc])
                continue;

            for (Pair vp : adj.get(pu)) {
                int node = vp.to;
                int nodewt = vp.wt;

                int nextch = (labels.charAt(node) == labels.charAt(pu)) ? pc + 1 : 1;

                if (nextch > k)
                    continue;

                if (pw + nodewt < dist[node][nextch]) {
                    dist[node][nextch] = pw + nodewt;
                    pq.offer(new Pair(node, dist[node][nextch], nextch));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            min = Math.min(min, dist[n - 1][i]);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}