class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total=0;
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            max=Math.max(sum, max);
            if(sum<0)sum=0;
            total+=nums[i];
        }
        
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            min=Math.min(sum, min);
            if(sum>0)sum=0;
        }
        if(total==min)return max;
        return Math.max(total-min, max);
    }
}