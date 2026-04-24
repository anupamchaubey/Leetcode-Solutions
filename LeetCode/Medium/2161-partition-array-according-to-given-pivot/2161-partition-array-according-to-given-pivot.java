class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length;
        int[] res = new int[n];

        int l=0, r=n-1;
        for(int i=0, j=n-1; i<n && j>=0; i++, j--){
            if(nums[i]<pivot){
                res[l++]=nums[i];
            }
            if(nums[j]>pivot){
                res[r--]=nums[j];
            }
        }
        while(l<=r){
            res[l++]=pivot;
        }
        return res;
        
    }
}