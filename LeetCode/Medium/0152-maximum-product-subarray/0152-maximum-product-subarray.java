class Solution {
    public int maxProduct(int[] nums) {
        int maxSubarray=nums[0];
        int currMax=nums[0];
        int currMin=nums[0];
        for(int i=1;i<nums.length;i++){
            
            int tempMax=Math.max(nums[i], Math.max(nums[i]*currMax, nums[i]*currMin));
            int tempMin=Math.min(nums[i], Math.min(nums[i]*currMax, nums[i]*currMin));
            currMax=tempMax;
            currMin=tempMin;
            maxSubarray=Math.max(maxSubarray, tempMax);
        }
        return maxSubarray;
    }
}