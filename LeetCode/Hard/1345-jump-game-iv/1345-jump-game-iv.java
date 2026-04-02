class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1)
            return 0;
        HashMap<Integer, Set<Integer>> hm = new HashMap<>(); //arr[i], indexes with value arr[i]
        for (int i = 0; i < n; i++) {
            if (hm.containsKey(arr[i])) {
                hm.get(arr[i]).add(i);
            } else {
                hm.put(arr[i], new HashSet<>());
                hm.get(arr[i]).add(i);
            }
        }
        boolean[] visited = new boolean[n];
        visited[0] = true;

        Queue<Integer> q = new LinkedList<>();
        int steps = 0;
        q.offer(0);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int p = 0; p < size; p++) {
                int idx = q.poll();

                if (idx == n - 1)
                    return steps;

                if (idx + 1 < n && !visited[idx+1]) {
                    visited[idx + 1] = true;
                    q.offer(idx + 1);
                }
                if (idx - 1 >= 0 && !visited[idx-1]) {
                    visited[idx - 1] = true;
                    q.offer(idx - 1);
                }
                for (int i : hm.get(arr[idx])) {
                    if (!visited[i]) {
                        visited[i] = true;
                        q.offer(i);
                    }
                }
                hm.get(arr[idx]).clear();// imp
            }
            steps++;
        }
        return -1;
    }
}