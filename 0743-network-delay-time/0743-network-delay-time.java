class Solution {
    class Pair {
        int node;
        int t;

        Pair(int node, int time) {
            this.node = node;
            this.t = time;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<Pair>> adj = new HashMap<>();
        for (int i = 0; i < n; i++)
            adj.put(i + 1, new ArrayList<>());
        for (int[] ti : times) {
            adj.get(ti[0]).add(new Pair(ti[1], ti[2]));
        }

        Queue<Pair> q = new LinkedList<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        q.offer(new Pair(k, 0));
        dist[k] = 0;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int node = p.node;
            int t = p.t;
            if (dist[node] < t)
                continue;

            for (Pair pair : adj.get(node)) {
                int nei = pair.node;
                if (dist[nei] > t + pair.t) {
                    dist[nei] = t + pair.t;
                    q.offer(new Pair(nei, t + pair.t));
                }
            }
        }
        int totalTime = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            totalTime = Math.max(totalTime, dist[i]);
            if (totalTime == Integer.MAX_VALUE)
                return -1;
        }

        return totalTime;
    }
}