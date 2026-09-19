class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            ans = Math.min(ans, nums[mid]);
            if (nums[l] < nums[mid]) {
                ans = Math.min(ans, nums[l]);
                l = mid + 1;
            } else {
                ans = Math.min(ans, nums[r]);
                r = mid - 1;
            }
        }
        return ans;
    }
}