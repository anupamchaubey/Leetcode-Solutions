class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int l1 = 0;
        int prev1 = nums[0];
        int l2 = 0;
        int prev2 = nums[0];
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= prev1) {
                max = Math.max(max, i - l1);
                l1 = i;
            }
            if (nums[i] >= prev2) {
                max = Math.max(max, i - l2);
                l2 = i;
            }
            prev1 = nums[i];
            prev2 = nums[i];
            if (i == nums.length - 1) {
                max = Math.max(max, i - l1 + 1);
                max = Math.max(max, i - l2 + 1);
            }
        }
        return max;
    }
}