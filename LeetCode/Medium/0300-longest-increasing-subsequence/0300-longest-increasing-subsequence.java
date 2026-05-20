class Solution {
    // int[][] dp;
    public int lengthOfLIS(int[] nums) {

        // dp = new int[nums.length + 1][nums.length + 1];

        // int n = nums.length;

        // for(int idx = n-1; idx >= 0; idx--){
        //     for (int prev = idx; prev >= -1; prev--) {
        //         int ans = 0;
        //         if (prev == -1 || nums[idx] > nums[prev]) {
        //             ans = 1 + dp[idx+1][idx+1];
        //         }
        //         ans = Math.max(ans, dp[idx+1][prev+1]);
        //         dp[idx][prev+1]=ans;
        //     }
        // }
        // return dp[0][0];
        // return rec(nums, 0, -1);

        // int n=nums.length;
        // int[] dp=new int[n];
        
        // int max=1;
        // for(int i=0;i<n;i++){
        //     dp[i]=1;
        //     for(int prev=0;prev<i;prev++){
        //         if(nums[prev]<nums[i]){
        //             dp[i]=Math.max(dp[prev]+1, dp[i]);
        //         }
        //     }
        //     max=Math.max(max, dp[i]);
        // }
        // return max;

        int n=nums.length;
        int[] tails=new int[n];
        Arrays.fill(tails, Integer.MAX_VALUE);
        int max=1;
        for(int i=0;i<n;i++){
            int num=nums[i];
            
            int l=0, r=i;
            while(l<=r){
                int mid=(l+r)/2;
                if(num<=tails[mid]){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }
            tails[l]=num;
            max=Math.max(max, l+1);
        }
        return max;
    }

    // int rec(int[] nums, int idx, int prev) {
    //     if (idx == nums.length)
    //         return 0;
    //     if (prev != -1 && dp[idx][prev] != Integer.MAX_VALUE) {
    //         return dp[idx][prev];
    //     }
    //     int ans = 0;
    //     if (prev == -1 || nums[idx] > nums[prev]) {
    //         ans = 1 + rec(nums, idx + 1, idx);
    //     }
    //     ans = Math.max(ans, rec(nums, idx + 1, prev));
    //     if (prev != -1) {
    //         dp[idx][prev] = ans;
    //     }
    //     return ans;
    // }
}