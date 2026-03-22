class Solution {
    public long countSubarrays(int[] nums, long k) {
        return atmost(nums, k);
    }
    long atmost(int[] nums, long k){
        long score=0;
        long sum=0;
        long count=0;
        int left=0;
        for(int r=0;r<nums.length;r++){
            sum+=nums[r];
            score=sum*(r-left+1);

            while(score>=k){
                sum-=nums[left];
                left++;
                score=sum*(r-left+1);
            }
            count+=(r-left+1);
        }
        return count;
    }
}