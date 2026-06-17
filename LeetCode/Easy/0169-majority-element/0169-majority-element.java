class Solution {
    // Boyer-Moore Voting Algorithm
    public int majorityElement(int[] nums) {
        
        int candidate=nums[0];
        int count=0;

        for(int x:nums){
            if(count==0)candidate=x;
            if(x==candidate)count++;
            else count--;
        }

        return candidate;
    }
}