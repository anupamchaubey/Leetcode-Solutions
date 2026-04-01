class Solution {
    Integer[][] dp;
    public int maxCoins(int[] nums) {
        int n=nums.length;
        dp= new Integer[n+2][n+2];
        int[] arr= new int[n+2];
        for(int i=1;i<n+1;i++){
            arr[i]=nums[i-1];
        }
        arr[0]=1;
        arr[n+1]=1;
        return rec(arr, 0, n+1);

    }
    int rec(int[] nums, int st, int en){
        if(st+1==en)return 0;
        if(dp[st][en]!=null)return dp[st][en];
        int max=Integer.MIN_VALUE;
        for(int k=st+1;k<en;k++){// k represents last balloon to burst between range [st, en]
            int left=rec(nums, st, k);
            int right=rec(nums, k, en);
            int cost=nums[st]*nums[k]*nums[en]+left+right;
            max=Math.max(max, cost);
        }
        return dp[st][en]=max;
    }
}