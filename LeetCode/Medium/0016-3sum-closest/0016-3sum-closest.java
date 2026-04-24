class Solution {
    public int threeSumClosest(int[] nums, int target) {

        int ans = Integer.MAX_VALUE/2;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int sum = nums[i];
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int nsum = sum + nums[j] + nums[k];
                if (Math.abs(nsum - target) < Math.abs(ans - target)) {
                    ans = nsum;
                }
                if (nsum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ans;
    }
}