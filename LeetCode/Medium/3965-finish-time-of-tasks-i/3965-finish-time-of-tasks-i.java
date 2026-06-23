class Solution {

    public long finishTime(int n, int[][] edges, int[] baseTime) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
        }
        return dfs(adj, 0, baseTime);
    }

    long dfs(List<List<Integer>> adj, int node, int[] baseTime) {
        if (adj.get(node).isEmpty())
            return baseTime[node];
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for (int x : adj.get(node)) {
            long child = dfs(adj, x, baseTime);
            min = Math.min(min, child);
            max = Math.max(max, child);
        }
        long own = (max - min) + baseTime[node];
        return max + own;
    }

}