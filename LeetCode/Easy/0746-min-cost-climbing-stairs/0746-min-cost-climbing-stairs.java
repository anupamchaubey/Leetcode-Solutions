class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // int one=rec(cost, 0);
        // int sec=rec(cost, 1);

        int[] dp=new int[cost.length];
        dp[0]=cost[0];
        dp[1]=cost[1];

        for(int i=2;i<cost.length;i++){
            dp[i]=Math.min(dp[i-1]+cost[i], dp[i-2]+cost[i]);
        }
        return Math.min(dp[cost.length-1], dp[cost.length-2]);

        // return Math.min(one, sec);
    }
    int rec(int[] nums, int idx){
        if(idx>=nums.length)return 0;
        int ans=rec(nums, idx+1);
        ans=Math.min(ans, rec(nums, idx+2));
        return nums[idx]+ans;
    }
}