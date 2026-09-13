class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // ** Kahn's Algorithm ** 
        // int[] indegree = new int[numCourses];
        // List<List<Integer>> adj = new ArrayList<>();
        // for (int i = 0; i < numCourses; i++)
        //     adj.add(new ArrayList<>());

        // for (int[] arr : prerequisites) {
        //     indegree[arr[0]]++;
        //     adj.get(arr[1]).add(arr[0]);
        // }
        // Deque<Integer> q = new ArrayDeque<>();
        // for (int i = 0; i < indegree.length; i++) {
        //     if (indegree[i] == 0)
        //         q.offer(i);
        // }
        // while (!q.isEmpty()) {
        //     int x = q.poll();
        //     for (int v : adj.get(x)) {
        //         indegree[v]--;
        //         if (indegree[v] == 0) {
        //             q.offer(v);
        //         }
        //     }
        // }
        // for (int x : indegree)
        //     if (x > 0)
        //         return false;
        // return true;

        // ** Cycle detection Algorithm in Directed Graph **

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());
        for (int[] arr : prerequisites) {
            adj.get(arr[1]).add(arr[0]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] samePath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (cycle(adj, i, visited, samePath))
                    return false;
            }
        }
        return true;
    }

    boolean cycle(List<List<Integer>> adj, int v, boolean[] visited, boolean[] samePath) {
        visited[v] = true;
        samePath[v] = true;
        for (int x : adj.get(v)) {
            if (!visited[x]) {
                if (cycle(adj, x, visited, samePath))
                    return true;
            } else if (samePath[x]) {
                return true;
            }
        }
        samePath[v] = false;
        return false;
    }
}