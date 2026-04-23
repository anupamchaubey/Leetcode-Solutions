class Solution {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        int n=nums.length;
        int l=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            max=Math.max(max, sum);
            while(sum<0){
                sum-=nums[l++];
            }
        }
        return max;
    }
}