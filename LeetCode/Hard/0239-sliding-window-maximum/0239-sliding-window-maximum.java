class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int idx = 0;
        Deque<Integer> q = new ArrayDeque<>();
        int l = 0;
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
                q.pollLast();
            }
            q.addLast(i);

            while ((i - l + 1) > k) {
                if (q.peekFirst() <= l) {
                    q.pollFirst();
                }
                l++;

            }
            if (i < k - 1)
                continue;
            ans[idx++] = (q.isEmpty()) ? -1 : nums[q.peekFirst()];
        }
        return ans;
    }
}