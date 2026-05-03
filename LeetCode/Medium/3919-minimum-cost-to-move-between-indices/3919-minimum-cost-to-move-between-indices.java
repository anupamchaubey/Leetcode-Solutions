class Solution {
    public int[] minCost(int[] nums, int[][] queries) {

        int n = nums.length;

        int[] closest = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                closest[i] = 1;
            } else if (i == n - 1) {
                closest[i] = n - 2;
            } else {
                int left = Math.abs(nums[i - 1] - nums[i]);
                int right = Math.abs(nums[i + 1] - nums[i]);
                if (left <= right) {
                    closest[i] = i - 1;
                } else {
                    closest[i] = i + 1;
                }
            }
        }

        // moving from left to right
        int[] lcost = new int[n];
        for (int i = 0; i < n - 1; i++) {

            if (closest[i] == i + 1) {
                lcost[i + 1] = 1 + lcost[i];
            } else {
                lcost[i + 1] = lcost[i] + nums[i + 1] - nums[i];
            }
        }
        // moving from right to left
        int[] rcost = new int[n];
        for (int i = n - 1; i > 0; i--) {
            if (closest[i] == i - 1) {
                rcost[i - 1] = 1 + rcost[i];
            } else {
                rcost[i - 1] = nums[i] - nums[i - 1] + rcost[i];
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            if (l <= r) {
                ans[i] = lcost[r] - lcost[l];
            } else {
                ans[i] = rcost[r] - rcost[l];
            }
        }

        return ans;

    }
}