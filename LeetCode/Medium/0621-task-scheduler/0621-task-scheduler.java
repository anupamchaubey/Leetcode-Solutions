class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char ch : tasks) {
            freq[ch - 'A']++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1])
                return Integer.compare(a[1], b[1]);
            else
                return Integer.compare(freq[b[0]], freq[a[0]]);
        });

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(new int[] { i, 0 });
            }
        }
        int totalTasks = tasks.length;
        int count = 0;
        List<int[]> ls = new ArrayList<>();

        while (totalTasks > 0) {
            count++;
            int[] p = pq.poll();

            if (p[1] == 0) {
                freq[p[0]]--;
                totalTasks--;

                if (freq[p[0]] > 0) {
                    p[1] = n + 1;
                } else {
                    p[1] = Integer.MAX_VALUE;
                }
            }
            ls.add(p);
            while (!pq.isEmpty())
                ls.add(pq.poll());

            for (int[] task : ls) {
                if (task[1] > 0 && task[1] != Integer.MAX_VALUE) {
                    task[1]--;
                }
                if (task[1] != Integer.MAX_VALUE || freq[task[0]] > 0) {
                    pq.offer(task);
                }
            }
            ls.clear();
        }
        return count;
    }
}