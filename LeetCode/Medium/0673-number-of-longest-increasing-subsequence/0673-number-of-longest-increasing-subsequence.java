class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;

        int[] dp=new int[n];
        int[] cnt=new int[n];

        int max=1;

        for(int i=0;i<n;i++){
            dp[i]=1;
            cnt[i]=1;
            for(int prev=0;prev<i;prev++){
                if(nums[prev]<nums[i]){
                    if(dp[prev]+1>dp[i]){
                        cnt[i]=cnt[prev];
                        dp[i]=dp[prev]+1;
                    }else if(dp[prev]+1==dp[i]){
                        cnt[i]+=cnt[prev];
                    }
                }
            }
            max=Math.max(max, dp[i]);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(dp[i]==max)ans+=cnt[i];
        }
        return ans;
    }
}