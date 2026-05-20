class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        
        dp=new int[nums.length][nums.length];
        for(int[] d: dp)Arrays.fill(d, Integer.MAX_VALUE);

        return rec(nums, 0, -1);
    }
    int rec(int[] nums, int idx, int prev){
        if(idx==nums.length)return 0;
        if(prev!=-1 && dp[idx][prev]!=Integer.MAX_VALUE){
            return dp[idx][prev];
        }
        int ans=0;
        if(prev==-1 || nums[idx]>nums[prev]){
            ans=1+rec(nums, idx+1, idx);
        }
        ans=Math.max(ans, rec(nums, idx+1, prev));
        if(prev!=-1){
            dp[idx][prev]=ans;
        }
        return ans;
    }
}