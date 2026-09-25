class Solution {
    public long maximumScore(int[] nums, String s) {
        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
            if (s.charAt(i) == '1') {
                sum += pq.poll();
            }
        }
        return sum;
    }
}