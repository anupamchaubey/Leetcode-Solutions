class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] arr = new int[nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
                q.pollLast();
            }
            q.addLast(i);
            while (!q.isEmpty() && i - q.peekFirst() + 1 > k) {
                q.pollFirst();
            }
            if (i >= k - 1) {
                arr[i - k + 1] = nums[q.peekFirst()];
            }
        }
        return arr;
    }
}