class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int i=0, j=0, k=nums.length-1;

        while(j<=k){
            if(nums[j]<pivot){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                j++;
                i++;
            }else if(nums[j]==pivot){
                j++;
            }else{
                int temp=nums[k];
                nums[k]=nums[j];
                nums[j]=temp;
                k--;
            }
        }
        i=k+1;
        j=nums.length-1;
        while(i<j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
        return nums;
    }
}