class Solution {
    public int jump(int[] nums) {
        int l=0, r=nums.length-1;
        int ans=nums.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(canReach(nums, mid)){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    boolean canReach(int[] nums, int j){
        int jumps=0;
        int far=0;
        int max=0;
        for(int i=0;i<nums.length-1;i++){
            far=Math.max(far, i+nums[i]);
            if(i>=max){
                jumps++;
                max=far;
            }
        }
        return jumps<=j;
    }
}