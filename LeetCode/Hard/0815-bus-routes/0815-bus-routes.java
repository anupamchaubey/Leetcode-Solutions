class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        int m = routes.length;
        if(source==target)return 0;
        
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
        for (int i = 0; i < m; i++) {
            hm.putIfAbsent(i, new HashSet<>());
            for (int x : routes[i]) {
                hm.get(i).add(x);
            }
        }
        boolean[] visited = new boolean[m];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j : routes[i]) {
                if (j == source) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
        int buses = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int r = q.poll();
                if (hm.get(r).contains(target))
                    return buses;
                for (int stops : hm.get(r)) {

                    for (int idx = 0; idx < m; idx++) {
                        if (!visited[idx]) {
                            if (hm.get(idx).contains(stops)) {
                                visited[idx] = true;
                                q.offer(idx);
                            }
                        }
                    }
                    // if (r > 0 && !visited[r - 1] && hm.get(r - 1).contains(stops)) {
                    //     visited[r - 1] = true;
                    //     q.offer(r - 1);
                    // }
                    // if (r + 1 < m && !visited[r + 1] && hm.get(r + 1).contains(stops)) {
                    //     visited[r + 1] = true;
                    //     q.offer(r + 1);
                    // }

                }
            }
            buses++;
        }
        return -1;
    }
}