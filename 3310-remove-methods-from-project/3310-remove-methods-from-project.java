class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        boolean[] visited = new boolean[n];
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();

        for (int[] inv : invocations) {
            int a = inv[0];
            int b = inv[1];
            hm.putIfAbsent(a, new HashSet<>());
            hm.get(a).add(b);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(k);
        visited[k] = true;

        while (!q.isEmpty()) {
            int poll = q.poll();
            for (int x : hm.getOrDefault(poll, new HashSet<>())) {
                if (!visited[x]) {
                    q.offer(x);
                    visited[x] = true;
                }
            }
        }

        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ls.add(i);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                for (int x : hm.getOrDefault(i, new HashSet<>())) {
                    if (visited[x])
                        return ls;
                }
                ans.add(i);
            }
        }

        return ans;
    }
}