class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // int one=rec(cost, 0);
        // int sec=rec(cost, 1);

        // int[] dp=new int[cost.length];
        // dp[0]=cost[0];
        // dp[1]=cost[1];

        int one=cost[0];
        int sec=cost[1];

        for(int i=2;i<cost.length;i++){
            int x=cost[i]+Math.min(sec, one);
            one=sec;
            sec=x;
        }
        return Math.min(one, sec);
        
        // return Math.min(dp[cost.length-1], dp[cost.length-2]);

        // return Math.min(one, sec);
    }
    int rec(int[] nums, int idx){
        if(idx>=nums.length)return 0;
        int ans=rec(nums, idx+1);
        ans=Math.min(ans, rec(nums, idx+2));
        return nums[idx]+ans;
    }
}