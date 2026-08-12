class Solution {
    public int longestConsecutive(int[] nums) {

        int max = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashSet<Integer> hs = new HashSet<>();
        for (int x : nums)
            if (!hs.contains(x)) {
                pq.offer(x);
                hs.add(x);
            }

        int l = 0;
        int prev = -1;
        while (!pq.isEmpty()) {
            int x = pq.poll();
            if (l == 0) {
                l++;
                prev = x;
            } else if (x == prev + 1) {
                l++;
                prev = x;
            } else {
                l = 1;
                prev = x;
            }
            max = Math.max(max, l);
        }
        return max;
    }
}