class Solution {
    public boolean check(int[] nums) {
        
        
        int n=nums.length;
        int idx=-1;
        for(int i=1;i<n;i++){
            if(nums[i]<nums[i-1]){
                idx=i;
                break;
            }
        }
        if(idx==-1)return true;
        if(nums[n-1]>nums[0])return false;
        for(int i=idx+1;i<n;i++){
            if(nums[i]<nums[i-1])return false;
        }
        return true;
    }
}