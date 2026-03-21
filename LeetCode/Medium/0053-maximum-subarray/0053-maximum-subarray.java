class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0;
        int st=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            max=Math.max(max, sum);
            if(sum<0){
                st=i;
                sum=0;
            }
            
        }
        return max;
    }
}