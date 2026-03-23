class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left=0, right=nums.length-1;
        while(left<right){
            while(left<right && nums[left]%2==0)left++;
            while(right>left && nums[right]%2!=0)right--;
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            
        }
        return nums;
    }
}