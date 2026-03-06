class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] tails=new int[n];
        int size=0;
        for(int v:nums){
            int l=0, r=size;
            while(l<r){
                int mid=(l+r)/2;
                if(tails[mid]>=v){
                    r=mid;
                }else{
                    l=mid+1;
                }
            }
            tails[l]=v;
            if(l==size)size++;
        }
        return size;
    }
}