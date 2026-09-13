class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());

        for (int[] arr : prerequisites) {
            indegree[arr[0]]++;
            adj.get(arr[1]).add(arr[0]);
        }
        List<Integer> ls = new ArrayList<>();

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                ls.add(i);
            }
        }
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int v : adj.get(x)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    q.offer(v);
                    ls.add(v);
                }
            }
        }
        if (ls.size() < numCourses)
            return new int[] {};
        int[] arr = new int[numCourses];
        int i = 0;
        for (int x : ls)
            arr[i] = ls.get(i++);

        return arr;
    }
}