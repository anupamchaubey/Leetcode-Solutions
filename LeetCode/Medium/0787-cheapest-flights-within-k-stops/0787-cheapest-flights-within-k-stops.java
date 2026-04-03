class Solution {
    class Pair {
        int flight;
        int price;

        Pair(int flight, int price) {
            this.flight = flight;
            this.price = price;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] f : flights) {
            int u = f[0];
            int v = f[1];
            int cost = f[2];
            adj.get(u).add(new Pair(v, cost));
        }

        int[][] dist = new int[n][k + 2];
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dist[src][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // dst, price, steps

        pq.offer(new int[] { src, 0, 0 });

        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int u = arr[0];
            int priceTillNow = arr[1];
            int stepsTillNow = arr[2];

            if (stepsTillNow > k)
                continue;

            for (Pair p : adj.get(u)) {
                int v = p.flight;
                int cost = p.price; // cost to destination v from u

                if (dist[v][stepsTillNow + 1] > dist[u][stepsTillNow] + cost) {
                    dist[v][stepsTillNow + 1] = dist[u][stepsTillNow] + cost;
                    pq.offer(new int[] { v, dist[v][stepsTillNow + 1], stepsTillNow + 1 });
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<=k+1;i++){
            min=Math.min(min, dist[dst][i]);
        }
        if(min==Integer.MAX_VALUE)return -1;
        return min;
    }
}