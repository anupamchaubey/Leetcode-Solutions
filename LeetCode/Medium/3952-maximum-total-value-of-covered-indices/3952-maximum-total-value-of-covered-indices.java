class Solution {
    Long[][] dp;
    public long maxTotal(int[] nums, String s) {
        dp=new Long[s.length()][2];
        long ans = rec(nums, s, 1, (s.charAt(0) == '1') ? 1 : 0);
        ans += (s.charAt(0) == '1') ? nums[0] : 0;
        return ans;
    }

    long rec(int[] nums, String s, int idx, int lastUsed) {
        if (idx == s.length())
            return 0;
        if(dp[idx][lastUsed]!=null)return dp[idx][lastUsed];
        long ans = 0;
        if (s.charAt(idx) == '1') {
            if (lastUsed==0) {
                ans = nums[idx - 1] + rec(nums, s, idx + 1, 0);
            }
            ans = Math.max(ans, nums[idx] + rec(nums, s, idx + 1, 1));
        }else{
            return dp[idx][lastUsed]= rec(nums, s, idx + 1, 0);
        }
        return dp[idx][lastUsed]= ans;
    }
}