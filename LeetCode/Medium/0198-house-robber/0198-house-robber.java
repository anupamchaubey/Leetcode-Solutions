class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        int[] dp= new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0], nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        return dp[nums.length-1];
    }
    int rec(int[] nums, int i, Integer[] dp){
        if(i>=nums.length)return 0;
        if(dp[i]!=null)return dp[i];
        int x=0, y=0;
        x=nums[i]+rec(nums, i+2, dp);
        y=rec(nums, i+1, dp);
        return dp[i]=Math.max(x, y);

    }
}