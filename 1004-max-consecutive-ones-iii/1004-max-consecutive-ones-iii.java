class Solution {
    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int ones = 0;
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)
                ones++;
            if (i - l + 1 - ones > k) {
                if (nums[l] == 1)
                    ones--;
                l++;
            }
            max = Math.max(max, i - l + 1);
        }
        return max;
    }
}