class Solution {
    public int splitArray(int[] nums, int k) {
        int l=0, r=0;
        for(int num: nums){
            l=Math.max(l, num);
            r+=num;
        }
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(canSplit(nums, mid, k)){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    boolean canSplit(int[] nums, int maxSum, int k){
        int subarrays=1;
        int currSum=0;
        for(int i=0;i<nums.length;i++){
            if(currSum+nums[i]>maxSum){
                subarrays++;
                currSum=nums[i];
                if(subarrays>k)return false;
            }else{
                currSum+=nums[i];
            }
        }
        return true;
    }
}