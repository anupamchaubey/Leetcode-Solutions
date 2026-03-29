class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp= new int[nums.length];
        Arrays.fill(dp, 1);
        int max=1;
        for(int i=1;i<nums.length;i++){
            
            for(int prev=0;prev<i;prev++){
                
                if(nums[i]> nums[prev]){
                    dp[i]=Math.max(dp[i], dp[prev]+1);
                }
            }
            max=Math.max(dp[i], max);
        }
        return max;
    }
}