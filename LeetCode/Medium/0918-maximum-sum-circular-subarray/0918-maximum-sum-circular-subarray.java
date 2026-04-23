class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int linearmin = Integer.MAX_VALUE;
        int sum2 = 0;
        int linearmax = Integer.MIN_VALUE;
        int sum = 0;
        int n = nums.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            linearmax = Math.max(linearmax, sum);
            if (sum < 0)
                sum = 0;
            sum2 += nums[i];
            linearmin = Math.min(sum2, linearmin);
            if (sum2 > 0)
                sum2 = 0;
            total += nums[i];
        }
        if (linearmax < 0)
            return linearmax;

        return Math.max(linearmax, total - linearmin);
    }
}