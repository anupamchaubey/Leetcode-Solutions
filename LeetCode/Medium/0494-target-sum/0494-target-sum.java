class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        return rec(nums, 0, target, 0);
    }
    int rec(int[] nums, int idx, int target, int sum){
        if(idx>=nums.length){
            if(sum==target){
                return 1;
            }
            return 0;
        }
        int c=0;
        c+=rec(nums, idx+1, target, sum+nums[idx]);
        c+=rec(nums, idx+1, target, sum-nums[idx]);
        return c;
    }
}