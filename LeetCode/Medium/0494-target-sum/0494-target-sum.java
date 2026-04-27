class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        

        return ways(nums, 0, target);
    }
    int ways(int[] nums, int idx, int target){
        if(idx==nums.length ){
            if(target==0)return 1;
            return 0;
        }
        int count=0;
        count+=ways(nums, idx+1, target-nums[idx]);
        count+=ways(nums, idx+1, target+nums[idx]);
        return count;
    }
}