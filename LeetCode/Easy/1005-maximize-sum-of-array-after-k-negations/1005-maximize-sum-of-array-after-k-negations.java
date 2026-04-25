class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);

        int i=0;
        while(i<nums.length && nums[i]<0 && k>0){
            nums[i]=-nums[i];
            k--;
            i++;
        }
        int total=0;
        for(int x:nums)total+=x;

        if(k%2!=0){
            int min=Integer.MAX_VALUE;
            for(int x:nums){
                min=Math.min(min, x);
            }
            return total-2*min;
        }
        return total;
        

    }
}