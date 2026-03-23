class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int ev=0, od=1;
        while(ev<nums.length && od<nums.length){
            while(ev<nums.length && nums[ev]%2==0)ev+=2;
            while(od<nums.length && nums[od]%2!=0)od+=2;
            if(ev>=nums.length || od>=nums.length)break;
            int temp=nums[ev];
            nums[ev]=nums[od];
            nums[od]=temp;
        }
        return nums;
    }
}