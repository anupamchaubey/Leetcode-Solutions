class Solution {
    class Node {
        int node;
        int bit;
        int len;

        Node(int node, int bit, int len) {
            this.node = node;
            this.bit = bit;
            this.len = len;
        }
    }

    public int shortestPathLength(int[][] graph) {

        int n = graph.length;
        boolean[][] visited = new boolean[n][1 << n];
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int mask = (1 << i);
            visited[i][mask] = true;
            q.offer(new Node(i, mask, 0));
        }
        int targetBit = (1 << n) - 1;
        while (!q.isEmpty()) {
            Node x = q.poll();
            int node = x.node;
            int b = x.bit;
            int l = x.len;
            if (b == targetBit)
                return l;

            for (int nei : graph[node]) {
                int newb = ((1 << nei) | b);

                if (!visited[nei][newb]) {
                    visited[nei][newb] = true;
                    q.offer(new Node(nei, newb, l + 1));
                }
            }
        }
        return -1;
    }
}