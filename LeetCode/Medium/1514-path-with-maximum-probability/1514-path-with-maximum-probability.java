class Solution {

    class Pair {
        int node;
        double wt;

        Pair(int node, double wt) {
            this.node = node;
            this.wt = wt;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succ, int start_node, int end_node) {

        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double wt = succ[i];

            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.wt, a.wt));

        pq.offer(new Pair(start_node, 1.00000));

        double[] prob = new double[n];
        Arrays.fill(prob, Double.MIN_VALUE);
        prob[start_node] = 1.00000;

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int node = p.node;

            for (Pair pair : adj.get(node)) {
                int v = pair.node;
                double w = pair.wt;

                if (prob[node] * w > prob[v]) {
                    prob[v] = prob[node] * w;
                    pq.offer(new Pair(v, prob[v]));
                }
            }
        }
        return prob[end_node];
    }
}