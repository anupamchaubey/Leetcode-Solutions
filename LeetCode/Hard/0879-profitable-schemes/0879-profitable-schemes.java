class Solution {
    int MOD = 1_000_000_007;
    Integer[][][] dp;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        dp= new Integer[n+1][minProfit+1][profit.length+1];
        return rec(n, group, profit, minProfit, 0, 0);
       
    }
    int rec(int n, int[] group, int[] profit, int target, int sum, int idx){
        
        if(n<0)return 0;
        if(idx==profit.length){
            if(sum>=target){
                return 1;
            }
            return 0;
        }
        sum = Math.min(sum, target);
        if(dp[n][sum][idx]!=null)return dp[n][sum][idx];
        int count=0;
        count+=rec(n-group[idx], group, profit, target, sum+profit[idx], idx+1);
        count+=rec(n, group, profit, target, sum, idx+1);
        return dp[n][sum][idx]=(count% MOD);
    }
}