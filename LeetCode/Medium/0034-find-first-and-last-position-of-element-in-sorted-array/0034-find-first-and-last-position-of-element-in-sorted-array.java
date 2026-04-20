class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans={-1, -1};
        
        ans[0]=findBound(nums, target, true);
        if(ans[0]==-1)return ans;
        ans[1]=findBound(nums, target, false);
        return ans;
    }
    private int findBound(int[] nums, int target, boolean first){

        int ans=-1;

        int left=0, right=nums.length-1;

        while(left<=right){
            int mid=left+(right-left)/2;

            if(nums[mid]==target){
                ans=mid;
                if(first){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else if(target<nums[mid]){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
}