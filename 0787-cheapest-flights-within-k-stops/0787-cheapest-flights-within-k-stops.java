class Solution {
    class Pair {
        int city;
        int time;

        Pair(int city, int time) {
            this.city = city;
            this.time = time;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] f : flights) {
            int u = f[0];
            int v = f[1];
            int c = f[2];
            adj.get(u).add(new Pair(v, c));
        }
        int[][] dist = new int[n][k + 2];
        for (int[] d : dist)
            Arrays.fill(d, Integer.MAX_VALUE);
        dist[src][0] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));// city, time, stops
        q.offer(new int[] { src, 0, 0 });
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int u = poll[0];
            int t = poll[1];
            int stops = poll[2];
            if (stops > k)
                continue;
            for (Pair p : adj.get(u)) {
                int v = p.city;
                int curr = p.time;
                if (dist[v][stops + 1] > curr + t) {
                    dist[v][stops + 1] = curr + t;
                    q.offer(new int[] { v, dist[v][stops + 1], stops + 1 });
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int x : dist[dst]) {
            min = Math.min(min, x);
        }
        if (min == Integer.MAX_VALUE)
            return -1;
        return min;
    }
}