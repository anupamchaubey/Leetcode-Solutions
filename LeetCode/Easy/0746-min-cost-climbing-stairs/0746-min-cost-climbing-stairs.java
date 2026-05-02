class Solution {
    Integer dp[];
    public int minCostClimbingStairs(int[] cost) {
        dp=new Integer[cost.length];
        return Math.min(rec(cost, 0), rec(cost, 1));
    }
    int rec(int[] cost, int idx){
        if(idx>=cost.length)return 0;
        if(dp[idx]!=null)return dp[idx];
        return dp[idx]=cost[idx]+Math.min(rec(cost, idx+1), rec(cost, idx+2));
    }
}