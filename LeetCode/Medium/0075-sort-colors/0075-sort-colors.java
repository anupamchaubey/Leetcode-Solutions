class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int st=0, mid=0, en=n-1;
        while(mid<=en){
            if(nums[mid]==0){
                int temp=nums[st];
                nums[st]=nums[mid];
                nums[mid]=temp;
                st++;
                mid++;
            }else if(nums[mid]==2){
                int temp=nums[en];
                nums[en]=nums[mid];
                nums[mid]=temp;
                en--;
            }else{
                mid++;
            }
        }
    }
}