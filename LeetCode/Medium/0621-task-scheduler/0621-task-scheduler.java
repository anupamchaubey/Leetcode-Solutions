class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char ch : tasks) {
            freq[ch - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> b-a);
        for (int f : freq) {
            if (f > 0)
                pq.offer(f);
        }
        int time = 0;
        while (!pq.isEmpty()) {
            int gap = n + 1;
            List<Integer> temp = new ArrayList<>();
            while (gap > 0 && !pq.isEmpty()) {
                int x = pq.poll();
                x--;
                gap--;
                time++;
                if (x > 0)
                    temp.add(x);
            }
            for (int x : temp)
                pq.offer(x);
            if (pq.isEmpty())
                break;
            time += gap;
        }
        return time;
    }
}