class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[] { i, 1 });
                color[i] = 1;
                while (!q.isEmpty()) {
                    int[] arr = q.poll();
                    int u = arr[0];
                    int c = arr[1];
                    for (int v : graph[u]) {
                        int nc = 0;
                        if (c == 1)
                            nc = 2;
                        else
                            nc = 1;
                        if (color[v] == -1) {
                            color[v] = nc;
                            q.offer(new int[] { v, nc });
                        } else if (color[v] != nc) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}