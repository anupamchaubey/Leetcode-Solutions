class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return rec(nums, 0, target);
    }
    int rec(int[] nums, int idx, int target){
        if(idx==nums.length){
            if(target==0)return 1;
            return 0;
        }
        int count=0;
        count+=rec(nums, idx+1, target-nums[idx]);
        count+=rec(nums, idx+1, target+nums[idx]);
        return count;
    }
}