class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> ls = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            ls.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    ls.get(i).add(j);
                }
            }
        }
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, ls, visited);
                count++;
            }

        }
        return count;

    }

    void bfs(int src, List<List<Integer>> ls, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        visited[src] = true;
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int i = 0; i < ls.get(x).size(); i++) {
                if (!visited[ls.get(x).get(i)]) {
                    visited[ls.get(x).get(i)] = true;
                    q.offer(ls.get(x).get(i));
                }
            }
        }
    }

}