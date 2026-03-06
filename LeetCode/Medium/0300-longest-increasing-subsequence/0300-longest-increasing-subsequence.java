class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] tails=new int[n];
        int size=0;
        for(int i=0;i<n;i++){
            int l=0;
            int r=size;
            while(l<r){
                int mid=(l+r)/2;
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