class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // exactly k= atmost k - atmost k-1
        return atmost(nums, goal)-atmost(nums, goal-1);
    }
    int atmost(int[] nums, int k){
        if(k<0)return 0;
        int count=0;
        int sum=0;
        int left=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];

            while(sum>k){
                sum-=nums[left];
                left++;
            }
            count+=(i-left+1);
        }
        return count;
    }
    
}