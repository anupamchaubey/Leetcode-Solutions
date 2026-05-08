class Solution {
    int[] dp;
    public int jump(int[] nums) {
        dp=new int[nums.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        return rec(nums, 0);
    }
    int rec(int[] nums, int idx){
        if(idx==nums.length-1)return 0;
        if(dp[idx]!=Integer.MIN_VALUE)return dp[idx];
        int jumps=Integer.MAX_VALUE/2;
        for(int i=idx+1;i<nums.length && i<=idx+nums[idx];i++){
            jumps=Math.min(jumps, 1+rec(nums, i));
        }
        return dp[idx]=jumps;
    }
}