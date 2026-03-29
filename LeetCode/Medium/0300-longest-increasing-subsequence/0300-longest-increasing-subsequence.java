class Solution {
    public int lengthOfLIS(int[] nums) {
        //longest increasing subsequence ending at index i
        int n=nums.length;
        int[] tails=new int[n];
        int size=0;
        for(int i=0;i<n;i++){
            int l=0, r=size;
            while(l<r){
                int mid=l+(r-l)/2;
                if(tails[mid]<nums[i]){
                    l=mid+1;
                }else{
                    r=mid;
                }
            }
            tails[l]=nums[i];
            if(l==size)size++;
        }
        return size;
    }
}