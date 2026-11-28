class Solution {
    public int longestOnes(int[] nums, int k) {

        int n = nums.length;
        int max = 0, l = 0, r = 0;
        int one = 0;

        while (r < n) {
            if (nums[r] == 1)
                one++;
            if ((r - l + 1) - one > k) {
                if (nums[l] == 1)
                    one--;
                l++;
            }
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }
}