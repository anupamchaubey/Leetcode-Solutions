class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> q = new ArrayDeque<>();

        int[] arr = new int[nums.length - k + 1];
        for (int i = 0; i < n; i++) {
            while (q.size() > 0 && nums[q.peekLast()] <= nums[i])
                q.pollLast();
            q.addLast(i);
            while (i - q.peekFirst() + 1 > k)
                q.pollFirst();
            if (i >= k - 1) {
                arr[i - k + 1] = nums[q.peekFirst()];
            }
        }

        return arr;
    }
}