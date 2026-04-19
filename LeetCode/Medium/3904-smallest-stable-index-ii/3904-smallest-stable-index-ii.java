class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] max = new int[n];
        int[] min = new int[n];
        for (int i = 0; i < n; i++) {
            max[i] = (i == 0) ? nums[i] : Math.max(max[i - 1], nums[i]);
        }
        for (int i = n - 1; i >= 0; i--) {
            min[i] = (i == n - 1) ? nums[i] : Math.min(min[i + 1], nums[i]);
        }
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = max[i] - min[i];
            if (score[i] <= k) {
                return i;
            }
        }
        return -1;

    }
}