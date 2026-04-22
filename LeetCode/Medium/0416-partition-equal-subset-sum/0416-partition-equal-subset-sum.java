class Solution {
    public boolean canPartition(int[] nums) {
        int m=nums.length;
        int sum=0;
        for(int x:nums)sum+=x;
        if(sum%2!=0)return false;
        sum/=2;
        int[][] dp = new int[m+1][sum+1];
        for(int i=1;i<=m;i++){
            for(int w=1;w<=sum;w++){
                if(nums[i-1]<=w){
                    dp[i][w]=Math.max(dp[i-1][w], nums[i-1]+dp[i-1][w-nums[i-1]]);
                }else{
                    dp[i][w]=dp[i-1][w];
                }
            }
        }
        return dp[m][sum]==sum;
    }
}