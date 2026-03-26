class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char ch : tasks)
            freq[ch - 'A']++;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int f : freq) {
            if (f > 0)
                pq.offer(f);
        }
        int time = 0;

        while (!pq.isEmpty()) {
            int cycle = n + 1;
            List<Integer> ls = new ArrayList<>();
            while (cycle > 0 && !pq.isEmpty()) {
                int x = pq.poll();
                if (x - 1 > 0)
                    ls.add(x - 1);
                time++;
                cycle--;
            }
            for (int x : ls)
                pq.offer(x);

            if (pq.isEmpty())
                break;
            time += cycle;
        }
        return time;

    }
}