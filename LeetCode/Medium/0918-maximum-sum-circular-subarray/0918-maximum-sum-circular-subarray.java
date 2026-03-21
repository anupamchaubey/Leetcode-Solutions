class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max=Integer.MIN_VALUE;
        int n=nums.length;
        int sum=0;
        int total=0;
        for(int i=0;i<n;i++){
            total+=nums[i];
            sum+=nums[i];
            max=Math.max(max, sum);
            if(sum<0)sum=0;
        }
        //find the minimum subarray to subtract from the circular array, which gives the right answer
        int min=Integer.MAX_VALUE;
        sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            min=Math.min(sum, min);
            if(sum>0)sum=0;
        }
        if(total==min)return max;
        return Math.max(max, total-min);
    }
}