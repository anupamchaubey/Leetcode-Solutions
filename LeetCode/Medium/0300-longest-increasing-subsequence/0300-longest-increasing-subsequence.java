class Solution {
    public int lengthOfLIS(int[] nums) {
        return rec(nums, -1, 0);
    }
    int rec(int[] nums, int prev, int idx){
        if(idx==nums.length)return 0;

        int take=0;
        if(prev==-1 || nums[idx]>nums[prev]){
            take=1+rec(nums, idx, idx+1);
        }
        int nontake=rec(nums, prev, idx+1);

        return Math.max(take, nontake);
    }
}